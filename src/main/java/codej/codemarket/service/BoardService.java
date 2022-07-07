package codej.codemarket.service;

import codej.codemarket.domain.AttachDTO;
import codej.codemarket.domain.BoardDTO;
import codej.codemarket.paging.Criteria;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

     boolean registerBoard(BoardDTO boardDTO);

     boolean registerBoard(BoardDTO boardDTO, MultipartFile[] files);

     BoardDTO getBoardDetail(Long idx);

     boolean deleteBoard(Long idx);

      List<BoardDTO> getBoardList(BoardDTO boardDTO);

      int getBoardTotalCount(BoardDTO boardDTO);

      List<AttachDTO> getAttachFileList(Long boardIdx);


}
