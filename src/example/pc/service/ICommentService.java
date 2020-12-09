package example.pc.service;

import example.pc.dto.CommentSearchInfo;
import example.pc.entity.Comment;
import example.pc.entity.Page;

import java.util.List;

public interface ICommentService {
    void addComment(String name,String email,String content);
    int getPages();

    void deleteComment(Comment comment);

    List<Comment> getShowableCommon();

    List<Comment> getShowableCommonByPage(Page page);

    List<Comment> getSearchCommentsByPage(CommentSearchInfo searchInfo, Page page);

    int getPageCountBySearch(CommentSearchInfo commentSearchInfo);
}
