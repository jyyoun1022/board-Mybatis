package codej.codemarket.service;

import codej.codemarket.domain.BoardDTO;

import java.util.List;

public interface BoardService {

     boolean registerBoard(BoardDTO boardDTO);

     BoardDTO getBoardDetail(Long idx);

     boolean deleteBoard(Long idx);

      List<BoardDTO> getBoardList();


}
