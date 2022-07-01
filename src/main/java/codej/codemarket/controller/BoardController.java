package codej.codemarket.controller;

import codej.codemarket.domain.BoardDTO;
import codej.codemarket.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

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
    public String register(final BoardDTO boardDTO){
        try{
            boolean isRegistered = boardService.registerBoard(boardDTO);
            if(isRegistered == false){
                //게시글 등록이 실패하였다는 메시지를 전달
            }
        }catch (DataAccessException e){
            //데이터 베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
            e.printStackTrace();
        }catch (Exception e){
            //시스템에 문제가 발생하였다는 메시지를 전달
        }
        return "redirect:/board/list";
    }
    @GetMapping("/list")
    public void boardList(Model model){
        List<BoardDTO> boardList = boardService.getBoardList();
        model.addAttribute("boardList",boardList);
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
    public String delete(@RequestParam(value = "idx",required = false)Long idx){
        if(idx == null){
            //올바르지 않은 접근이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/board/list";
        }
        try{
            boolean isDeleted = boardService.deleteBoard(idx);
            if(isDeleted == false){
                //게시글 삭제에 실패했다는 메시지 전달
            }
        }catch (DataAccessException e){
            //데이터베이스 처리 과정에 문제가 발생했다는 메시지 전달
        }catch (Exception e){
            //시스템에 문제가 발생했다는 메시지 전달
        }
        return "redirect:/board/list";
    }
}
