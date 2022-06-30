package codej.codemarket.mappers;

import codej.codemarket.domain.BoardDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class MapperTests {

    @Autowired
    private  BoardMapper boardMapper;

    @Test
    public void testOfInsert(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("2번게시물 제목");
        boardDTO.setContent("2번 게시물 내용");
        boardDTO.setWriter("tester");

        int result = boardMapper.insertBoard(boardDTO);
        System.out.println("결과는 "+result+" 입니다.");
    }
    @Test
    public void testOfSelectDetail(){
        BoardDTO boardDTO = boardMapper.selectBoardDetail(1L);
        try {
            String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(boardDTO);
            System.out.println(boardJson);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

    }
    @Test
    public void testOfUpdate(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("1번 게시글 제목을 수정");
        boardDTO.setContent("1번 게시글 내용을 수정");
        boardDTO.setWriter("codej");
        boardDTO.setIdx(1L);

        int result = boardMapper.updateBoard(boardDTO);
        if(result ==1){
            BoardDTO board = boardMapper.selectBoardDetail(1L);
            try{
                String boardJSON = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
                System.out.println(boardJSON);
            }catch (JsonProcessingException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testOfDelete(){
        int result = boardMapper.deleteBoard(2L);
        if(result == 1){
            BoardDTO boardDTO = boardMapper.selectBoardDetail(2L);
            try {
                String board = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(boardDTO);
                System.out.println(board);
            }catch (JsonProcessingException e){
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testMultipleInsert(){
        for(int i=2; i<=50; i++){
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setTitle(i+" 번");
            boardDTO.setContent(i+ " 번 내용");
            boardDTO.setWriter(i +" 번 유저");
            boardMapper.insertBoard(boardDTO);
        }
    }
    @Test
    public void testSelectBoardList(){
        int totalCount = boardMapper.selectBoardTotalCount();
        System.out.println(totalCount);
        if(totalCount > 0 ){
            List<BoardDTO> boardDTOS = boardMapper.selectBoardList();
            if(CollectionUtils.isEmpty(boardDTOS) == false){
                for(BoardDTO board : boardDTOS){
                    try{
                        String boardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
                        System.out.println("boardJson = " + boardJson);
                        System.out.println(board.getTitle());
                        System.out.println(board.getContent());
                        System.out.println(board.getWriter());
                        System.out.println("=========\n");
                    }catch (JsonProcessingException e){
                        e.printStackTrace();
                    }

                }
            }
        }

    }

}
