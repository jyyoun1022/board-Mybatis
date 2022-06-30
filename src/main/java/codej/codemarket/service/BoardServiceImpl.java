package codej.codemarket.service;

import codej.codemarket.domain.BoardDTO;
import codej.codemarket.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private  final BoardMapper boardMapper;



    @Override
    public boolean registerBoard(BoardDTO boardDTO) {

        int queryResult = 0;

        if( boardDTO.getIdx() == null ){
            queryResult = boardMapper.insertBoard(boardDTO);
        }else{
            queryResult = boardMapper.updateBoard(boardDTO);
        }
        return (queryResult == 1) ? true : false ;
    }

    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {

        int queryResult = 0;

        BoardDTO  board = boardMapper.selectBoardDetail(idx);
        if( board != null && "N".equals(board.getDeleteYn())){
            queryResult = boardMapper.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BoardDTO> getBoardList() {

        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount();

        if(boardTotalCount > 0 ){
            boardList = boardMapper.selectBoardList();
        }
        return boardList;
    }
}
