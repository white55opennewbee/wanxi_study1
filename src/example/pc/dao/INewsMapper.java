package example.pc.dao;


import example.pc.dto.NewsSearchInfo;
import example.pc.entity.News;
import example.pc.entity.Page;


import java.util.List;
import java.util.Map;
/**
 * @author pc
 * @date 2020/12/12
 */
public interface INewsMapper {
     List<News> getAllNews();

     int getNewsPages();

     List<News> getNewsByPage(Page page);

     News getNewsById(int id);

     void updateNews(News news);

     void addNews(News news);

     void deleteById(News news);


     List<News> findNewsBySearch(Map map);

     int findNewsCountBySearch(NewsSearchInfo newsSearchInfo);

     boolean setNewsToTop(News news);

     List<News> getToTopNews();
}
