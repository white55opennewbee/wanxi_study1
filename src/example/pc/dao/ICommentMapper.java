package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.dto.CommentSearchInfo;
import example.pc.entity.Comment;
import example.pc.entity.Page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICommentMapper {
    List<Comment> getAllShowableCommons();

    List<Comment> getAllShowableCommonsByPage(Page page);

    List<Comment> getAllCommons();

    void addComment(Comment comment);


    void updateComment(Comment comment);


    void deleteComment(Comment comment);

    int getPages();

    List<Comment> getSearchComments(Map map);

    int getPagesCountBySearch(CommentSearchInfo commentSearchInfo);
}
