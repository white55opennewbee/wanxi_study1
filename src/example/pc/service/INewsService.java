package example.pc.service;

import example.pc.dto.NewsSearchInfo;
import example.pc.entity.News;
import example.pc.entity.Page;

import java.text.ParseException;
import java.util.List;

public interface INewsService {
    List<News> getAllNews() throws ParseException;
    List<News> getNewsByPage(Page currentPage);
    int getPages();
    News getNewsById(int id);
    void updateNews(News news);
    void addNews(News news);

    void deleteNewsById(String id);

    List<News> findNewsBySearch(NewsSearchInfo newsSearchInfo,Page page);

    int findNewsCountBySearch(NewsSearchInfo newsSearchInfo);

    Boolean setToTop(News news);

    List<News> getToTopNews();
}
