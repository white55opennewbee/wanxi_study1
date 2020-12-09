package example.pc.service.serviceImpl;

import example.pc.dto.NewsSearchInfo;
import example.pc.dao.NewsDao;
import example.pc.entity.News;
import example.pc.entity.Page;
import example.pc.service.INewsService;

import java.util.List;

public class NewsServiceImpl implements INewsService {
    NewsDao newsDao = new NewsDao();
    public List<News> getAllNews(){
        List<News> list;
        list = newsDao.getAllNews();
        return list;
    }

    @Override
    public int getPages() {
       int page =  newsDao.getNewsPages();
       return page;
    }

    @Override
    public News getNewsById(int id) {
       News news =  newsDao.getNewsById(id);
        return news;
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNews(news);
    }

    @Override
    public void addNews(News news) {
        newsDao.addNews(news);
    }

    @Override
    public void deleteNewsById(String id) {
        News news = new News();
        news.setStatus(0);
        news.setId(Integer.valueOf(id));
        newsDao.deleteById(news);
    }

    @Override
    public List<News> findNewsBySearch(NewsSearchInfo newsSearchInfo,Page page) {
      List<News> news =  newsDao.findNewsBySearch(newsSearchInfo,page);
      return news;
    }

    @Override
    public int findNewsCountBySearch(NewsSearchInfo newsSearchInfo) {
       int count = newsDao.findNewsCountBySearch(newsSearchInfo);
        return count;
    }

    @Override
    public Boolean setToTop(News news) {
        return newsDao.setNewsToTop(news);
    }

    @Override
    public List<News> getToTopNews() {
       List<News> list =  newsDao.getToTopNews();
        return list;
    }

    public List<News> getNewsByPage(Page currentPage){
        List<News> list;
        list =  newsDao.getNewsByPage(currentPage);
        return list;
    }

}
