package codej.codemarket.controller;

import codej.codemarket.constant.Method;
import codej.codemarket.domain.BoardDTO;
import codej.codemarket.paging.Criteria;
import codej.codemarket.service.BoardService;
import codej.codemarket.util.UiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController extends UiUtils {

    private final BoardService boardService;



    @GetMapping("/write")
    public String write(Model model,
                      @RequestParam(value = "idx",required = false) Long idx){

        if(idx == null){
            model.addAttribute("board",new BoardDTO());
        }else{
            BoardDTO boardDTO = boardService.getBoardDetail(idx);
            if( boardDTO == null){
                return "redirect:/board/list";
            }
            model.addAttribute("board",boardDTO);

        }
        return "/board/write";

    }
    @PostMapping("/register")
    public String register(final BoardDTO boardDTO,Model model){
        try{
            boolean isRegistered = boardService.registerBoard(boardDTO);
            if(isRegistered == false){
                return showMessageWithRedirect("게시글 등록에 실패했습니다.","/board/list", Method.GET,null,model);
            }
        }catch (DataAccessException e){
            //데이터 베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 생겼습니다.","/board/list",Method.GET,null,model);
        }catch (Exception e){
            //시스템에 문제가 발생하였다는 메시지를 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.","/board/list",Method.GET,null,model);
        }
        return showMessageWithRedirect("게시글 등록이 완료되었습니다.","/board/list",Method.GET,null,model);
    }
    @GetMapping("/list")
    public String boardList(Model model, @ModelAttribute("params")BoardDTO params){
//        int boardTotalCount = boardService.getBoardTotalCount(params);


        List<BoardDTO> boardList = boardService.getBoardList(params);
        model.addAttribute("boardList",boardList);

        return "/board/list";

    }
    @GetMapping("/read")
    public String boardDetail(Model model,
                              @RequestParam(value = "idx",required = false)Long idx){
        if(idx == null){
            //올바르지 않은 접근이라는 메시지를 전달,게시글리스트로 리다이렉트
            return "redirect:/board/list";
        }
        BoardDTO boardDTO = boardService.getBoardDetail(idx);
        if(boardDTO == null || "Y".equals(boardDTO.getDeleteYn())){
            //없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list";
        }
        model.addAttribute("board",boardDTO);
        return "/board/read";

    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "idx",required = false)Long idx,Model model){
        if(idx == null){
            //올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return showMessageWithRedirect("올바르지 않은 접근입니다.","/board/lit",Method.GET,null,model);
        }
        try{
            boolean isDeleted = boardService.deleteBoard(idx);
            if(isDeleted == false){
                //게시글 삭제에 실패했다는 메시지 전달
                return showMessageWithRedirect("게시글 삭제에 실패했습니다.","/board/list",Method.GET,null,model);
            }
        }catch (DataAccessException e){
            //데이터베이스 처리 과정에 문제가 발생했다는 메시지 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list", Method.GET, null, model);
        }catch (Exception e){
            //시스템에 문제가 발생했다는 메시지 전달
            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list", Method.GET, null, model);
        }
        return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/list", Method.GET, null, model);
    }
    }

