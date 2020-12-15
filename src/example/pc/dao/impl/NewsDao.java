package example.pc.dao.impl;

import example.pc.Utils.Mybatis_Utils;

import example.pc.dao.INewsMapper;
import example.pc.dto.NewsSearchInfo;

import example.pc.entity.News;
import example.pc.entity.Page;
import org.apache.ibatis.session.SqlSession;


import java.util.List;
import java.util.Map;

/**
 * @author pc
 * @date 2020/12/12
 */
public class NewsDao implements INewsMapper {
    @Override
    public List<News> getAllNews() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        List<News> allNews = mapper.getAllNews();
        return  allNews;
    }
    @Override
    public int getNewsPages() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        int newsPages = mapper.getNewsPages();
        return newsPages;
    }
    @Override
    public List<News> getNewsByPage(Page page) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        List<News> newsByPage = mapper.getNewsByPage(page);
        return newsByPage;
    }
    @Override
    public News getNewsById(int id) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        News newsById = mapper.getNewsById(id);
        return newsById;
    }
    @Override
    public void updateNews(News news) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        mapper.updateNews(news);
    }
    @Override
    public void addNews(News news) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        mapper.addNews(news);
    }
    @Override
    public void deleteById(News news) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        mapper.deleteById(news);
    }





    @Override
    public List<News> findNewsBySearch(Map map) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        List<News> newsBySearch = mapper.findNewsBySearch(map);
        return newsBySearch;
    }
    @Override
    public int findNewsCountBySearch(NewsSearchInfo newsSearchInfo) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        int newsCountBySearch = mapper.findNewsCountBySearch(newsSearchInfo);
        return newsCountBySearch;
    }
    @Override
    public boolean setNewsToTop(News news) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        boolean b = mapper.setNewsToTop(news);
        return b;
    }
    @Override
    public List<News> getToTopNews() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewsMapper mapper = sqlsession.getMapper(INewsMapper.class);
        List<News> toTopNews = mapper.getToTopNews();
        return toTopNews;
    }
}
