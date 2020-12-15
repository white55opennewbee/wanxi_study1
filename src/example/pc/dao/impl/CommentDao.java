package example.pc.dao.impl;

import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.ICommentMapper;
import example.pc.dto.CommentSearchInfo;
import example.pc.entity.Comment;
import example.pc.entity.Page;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * @author pc
 * @date 2020/12/12
 */
public class CommentDao implements ICommentMapper {
    @Override
    public List<Comment> getAllShowableCommons() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlsession.getMapper(ICommentMapper.class);
        List<Comment> allShowableCommons = mapper.getAllShowableCommons();
        return allShowableCommons;
    }

    @Override
    public List<Comment> getAllShowableCommonsByPage(Page page) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        List<Comment> allShowableCommonsByPage = mapper.getAllShowableCommonsByPage(page);
        return allShowableCommonsByPage;
    }

    @Override
    public List<Comment> getAllCommons() {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        List<Comment> allCommons = mapper.getAllCommons();

        return allCommons;

    }


    @Override
    public void addComment(Comment comment) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        mapper.addComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        mapper.updateComment(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        mapper.deleteComment(comment);
    }

    @Override
    public int getPages() {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        int pages = mapper.getPages();
        return pages;

    }


    @Override
    public List<Comment> getSearchComments(Map map) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        List<Comment> searchComments = mapper.getSearchComments(map);
        return searchComments;
    }

    @Override
    public int getPagesCountBySearch(CommentSearchInfo commentSearchInfo) {
        SqlSession sqlSession = Mybatis_Utils.getSqlsession();
        ICommentMapper mapper = sqlSession.getMapper(ICommentMapper.class);
        int pagesCountBySearch = mapper.getPagesCountBySearch(commentSearchInfo);
        return pagesCountBySearch;
    }
}
