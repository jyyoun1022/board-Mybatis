package codej.codemarket.comment;

import codej.codemarket.domain.CommentDTO;
import codej.codemarket.mappers.CommentMapper;
import codej.codemarket.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.ibatis.annotations.TypeDiscriminator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentTests {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    @DisplayName("댓글 등록")
    void registerComments(){
        int number =20;

        for(int i =0; i<= number; i++){
            CommentDTO params = new CommentDTO();
            params.setBoardIdx(249L);
            params.setContent(i+" 번 댓글을 추가");
            params.setWriter(i+" 번 회원");
            commentService.registerComment(params);
        }
        log.info("댓글 :"+number +"개가 등록되었습니다.");

    }

    @Test
    @DisplayName("댓글 하나 출력")
    void testOFDetail(){

        CommentDTO comment = commentMapper.selectCommentDetail(24L);
        try{
            String jsonComment = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(comment);
            System.out.println(jsonComment);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("댓글 삭제")
    void deleteComments(){
        commentService.deleteComment(23L);


    }

    @Test
    @DisplayName("댓글 리스트 출력")
    void getCommentList(){
        CommentDTO params = new CommentDTO();
        params.setBoardIdx(249L);
        commentService.getCommentList(params);
    }

}
