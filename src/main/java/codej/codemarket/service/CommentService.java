package codej.codemarket.service;

import codej.codemarket.domain.CommentDTO;

import java.util.List;

public interface CommentService {

    boolean registerComment(CommentDTO params);

    boolean deleteComment(Long idx);

    List<CommentDTO> getCommentList(CommentDTO params);
}
