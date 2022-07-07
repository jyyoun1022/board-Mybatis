package codej.codemarket.service;

import codej.codemarket.domain.AttachDTO;
import codej.codemarket.domain.BoardDTO;
import codej.codemarket.mappers.AttachMapper;
import codej.codemarket.mappers.BoardMapper;
import codej.codemarket.paging.Criteria;
import codej.codemarket.paging.PaginationInfo;
import codej.codemarket.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private  final BoardMapper boardMapper;
    private final AttachMapper attachMapper;
    private final  FileUtils fileUtils;



    @Override
    public boolean registerBoard(BoardDTO params) {
        int queryResult = 0;
        System.out.println("여기는 왜걸려?");
        System.out.println(params.getIdx());
        if (params.getIdx() == null) {
            System.out.println(queryResult);

            queryResult = boardMapper.insertBoard(params);
            System.out.println(queryResult);

        } else {
            queryResult = boardMapper.updateBoard(params);
        }


        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean registerBoard(BoardDTO params, MultipartFile[] files) {
        int queryResult = 1;
        System.out.println("여기는 1빠로 ");
        if (registerBoard(params) == false) {

            return false;
        }


        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getIdx());
        if (CollectionUtils.isEmpty(fileList) == false) {
            System.out.println("여기 거치냐");
            queryResult = attachMapper.insertAttach(fileList);

            if (queryResult < 1) {
                queryResult = 0;
            }
        }

        return (queryResult > 0);
    }


    @Override
    public BoardDTO getBoardDetail(Long idx) {
        return boardMapper.selectBoardDetail(idx);
    }

    @Override
    public boolean deleteBoard(Long idx) {
        int queryResult = 0;

        BoardDTO board = boardMapper.selectBoardDetail(idx);

        if (board != null && "N".equals(board.getDeleteYn())) {
            queryResult = boardMapper.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public List<BoardDTO> getBoardList(BoardDTO params) {
        List<BoardDTO> boardList = Collections.emptyList();

        int boardTotalCount = boardMapper.selectBoardTotalCount(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(boardTotalCount);

        params.setPaginationInfo(paginationInfo);

        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList(params);
        }

        return boardList;
    }

    @Override
    public int getBoardTotalCount(BoardDTO boardDTO) {
        int result = boardMapper.selectBoardTotalCount(boardDTO);
        return result;
    }

    @Override
    public List<AttachDTO> getAttachFileList(Long boardIdx) {

        int fileTotalCount = attachMapper.selectAttachTotalCount(boardIdx);

        if(fileTotalCount < 1){
             return  Collections.emptyList();
        }
        return attachMapper.selectAttachList(boardIdx);
    }
}