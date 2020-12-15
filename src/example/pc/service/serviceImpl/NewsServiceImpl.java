package example.pc.service.serviceImpl;

import example.pc.Utils.JedisUtiles;
import example.pc.dto.NewsSearchInfo;
import example.pc.dao.impl.NewsDao;
import example.pc.entity.News;
import example.pc.entity.Page;
import example.pc.service.INewsService;
import redis.clients.jedis.Jedis;

import java.util.*;

public class NewsServiceImpl implements INewsService {
    Jedis jedis = JedisUtiles.getJedis();
    NewsDao newsDao = new NewsDao();

    @Override
    public List<News> getAllNews() {
        List<News> list;
        list = newsDao.getAllNews();
        return list;
    }

    @Override
    public int getPages() {
        int page = newsDao.getNewsPages();
        return page;
    }

    @Override
    public News getNewsById(int id) {
        News news = newsDao.getNewsById(id);
        return news;
    }

    @Override
    public void updateNews(News news) {
        delRedisMsg();
        newsDao.updateNews(news);
    }

    @Override
    public void addNews(News news) {
        delRedisMsg();
        newsDao.addNews(news);
    }

    @Override
    public void deleteNewsById(String id) {
        News news = new News();
        news.setStatus(0);
        news.setId(Integer.valueOf(id));
        delRedisMsg();
        newsDao.deleteById(news);
    }

    @Override
    public List<News> findNewsBySearch(NewsSearchInfo newsSearchInfo, Page page) {
        Map map = new HashMap();
        map.put("newsSearchInfo", newsSearchInfo);
        map.put("page", page);
        List<News> news = newsDao.findNewsBySearch(map);
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
        List<News> list = newsDao.getToTopNews();
        return list;
    }


    private void delRedisMsg() {
        if (jedis.exists("WANXI_STUDY:NEWS:ID")) {
            jedis.del("WANXI_STUDY:NEWS:ID", "WANXI_STUDY:NEWS:DATE", "WANXI_STUDY:NEWS:TITLE", "WANXI_STUDY:NEWS:BODY", "WANXI_STUDY:NEWS:NEWSTYPE");
        }
        jedis.close();
    }

    @Override
    public List<News> getNewsByPage(Page currentPage) {
        List<News> list = new ArrayList<>();
        if (currentPage.getCurrentPage() == 1) {
            if (jedis.exists("WANXI_STUDY:NEWS:ID")) {
                System.out.println("NEWS FROM REDIS!!!!!");
                for (int i = 0; i < jedis.llen("WANXI_STUDY:NEWS:ID"); i++) {
                    News news = new News();
                    news.setId(Integer.valueOf(jedis.lindex("WANXI_STUDY:NEWS:ID", i)));
                    news.setDate(new Date(Long.valueOf(jedis.lindex("WANXI_STUDY:NEWS:DATE", i))));
                    news.setTitle(jedis.lindex("WANXI_STUDY:NEWS:TITLE", i));
                    news.setBody(jedis.lindex("WANXI_STUDY:NEWS:BODY", i));
                    news.setNewsType(jedis.lindex("WANXI_STUDY:NEWS:NEWSTYPE", i));
                    list.add(news);
                }

            } else {
                list = newsDao.getNewsByPage(currentPage);
                System.out.println("NEWS FROM JDBC");
                for (News news : list) {
                    jedis.rpush("WANXI_STUDY:NEWS:ID", news.getId() + "");
                    jedis.rpush("WANXI_STUDY:NEWS:DATE", news.getDate().getTime() + "");
                    jedis.rpush("WANXI_STUDY:NEWS:TITLE", news.getTitle() + "");
                    jedis.rpush("WANXI_STUDY:NEWS:BODY", news.getBody() + "");
                    jedis.rpush("WANXI_STUDY:NEWS:NEWSTYPE", news.getNewsType() + "");
                }
            }
        }else {
            list = newsDao.getNewsByPage(currentPage);
        }
        jedis.close();
        return list;
    }

}
