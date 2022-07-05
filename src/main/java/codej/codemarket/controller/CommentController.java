package codej.codemarket.controller;

import codej.codemarket.apater.GsonLocalDateTimeAdapter;
import codej.codemarket.domain.CommentDTO;
import codej.codemarket.service.CommentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{boardIdx}")
    public JsonObject getCommentList(@PathVariable("boardIdx")Long boardIdx,
                                     @ModelAttribute("params")CommentDTO params){

        JsonObject jsonObj = new JsonObject();

        List<CommentDTO> commentList = commentService.getCommentList(params);

        if(CollectionUtils.isEmpty(commentList) == false){

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();

            JsonArray jsonArr = gson.toJsonTree(commentList).getAsJsonArray();

            jsonObj.add("commentList",jsonArr);
        }

        return jsonObj;
    }

    @RequestMapping(value = {"","/{idx}"},method = {RequestMethod.POST,RequestMethod.PATCH})
    public JsonObject registerComment(@PathVariable(value = "idx",required = false)Long idx,
                                      @RequestBody final CommentDTO params){

        JsonObject jsonObj = new JsonObject();

        try{
            if( idx != null){
                params.setIdx(idx);
            }
            boolean isRegistered = commentService.registerComment(params);
            jsonObj.addProperty("result",isRegistered);
        }catch (DataAccessException e){
            jsonObj.addProperty("message","데이터 처리과정에서 문제가 발생하였습니다.");
        }catch (Exception e){
            jsonObj.addProperty("message","시스템 문제가 발생하였습니다.");
        }
        return jsonObj;
    }

}
