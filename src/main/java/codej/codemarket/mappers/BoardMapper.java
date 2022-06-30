package codej.codemarket.mappers;

import codej.codemarket.domain.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

     int insertBoard(BoardDTO params);

     BoardDTO selectBoardDetail(Long idx);

     int updateBoard(BoardDTO params);

     int deleteBoard(Long idx);

     List<BoardDTO> selectBoardList();

     int selectBoardTotalCount();

}
