package example.pc.service.serviceImpl;

import example.pc.dto.CommentSearchInfo;
import example.pc.dao.impl.CommentDao;
import example.pc.entity.Comment;
import example.pc.entity.Page;
import example.pc.service.ICommentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl implements ICommentService {
    CommentDao commentDao = new CommentDao();

    @Override
    public void addComment(String name, String email, String content) {
        Comment comment = new Comment();
        comment.setCommonUsername(name);
        comment.setUserEmail(email);
        comment.setUserCommon(content);
        commentDao.addComment(comment);
    }

    @Override
    public int getPages() {
        return commentDao.getPages();
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDao.deleteComment(comment);
    }

    @Override
    public List<Comment> getShowableCommon() {
        List<Comment> allShowableCommons = commentDao.getAllShowableCommons();
        return allShowableCommons;
    }

    @Override
    public List<Comment> getShowableCommonByPage(Page page) {
        return commentDao.getAllShowableCommonsByPage(page);
    }

    @Override
    public List<Comment> getSearchCommentsByPage(CommentSearchInfo searchInfo, Page page) {
        Map map = new HashMap();
        map.put("commentSearchInfo",searchInfo);
        map.put("page",page);
        List<Comment> list = commentDao.getSearchComments(map);
        return list;
    }

    @Override
    public int getPageCountBySearch(CommentSearchInfo commentSearchInfo) {
        int nums = commentDao.getPagesCountBySearch(commentSearchInfo);
        return nums;
    }
}
