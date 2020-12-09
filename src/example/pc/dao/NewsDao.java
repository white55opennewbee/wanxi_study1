package example.pc.dao;

import example.pc.dto.NewsSearchInfo;
import example.pc.Utils.ClassReflictionForDaoUtil;

import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.News;
import example.pc.entity.Page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class NewsDao {

    public List<News> getAllNews(){
        List<News> entities = ClassReflictionForDaoUtil.getEntities(News.class, Jdbc_Utils.getResultSet("select * from news"));
        return  entities;
    }

    public int getNewsPages() {
        ResultSet resultSet = null;
        resultSet = Jdbc_Utils.getResultSet("select count(*) from news");
        int anInt = 0;
        try {
            while (resultSet.next()){
                anInt = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return anInt;
    }

    public List<News> getNewsByPage(Page page) {
        String sql = "select * from news where status = 1 limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize();
        List<News> entities = ClassReflictionForDaoUtil.getEntities(News.class, Jdbc_Utils.getResultSet(sql));
        System.out.println(sql);
        return entities;
    }

    public News getNewsById(int id) {
        String sql = "select * from news where id =  "+id;
        List<News> entities = ClassReflictionForDaoUtil.getEntities(News.class, Jdbc_Utils.getResultSet(sql));
        System.out.println(sql);
        return entities.get(0);
    }

    public void updateNews(News news) {
        String sql = ClassReflictionForDaoUtil.updateSQL(news, "news");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(sql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNews(News news) {
        String sql = ClassReflictionForDaoUtil.insertSQL(news, "news");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(sql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(News news) {
        String sql = ClassReflictionForDaoUtil.updateSQL(news, "news");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(sql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private String buildSQL(NewsSearchInfo newsSearchInfo,String orginSQL){
        StringBuilder builder = new StringBuilder(orginSQL);
        if (newsSearchInfo.getNewsType()!=null&&!"全部".equals(newsSearchInfo.getNewsType().trim())){
            builder.append(" AND newsType = '"+newsSearchInfo.getNewsType()+"'");
        }
        if (newsSearchInfo.getNewsTitle()!=null&&!"".equals(newsSearchInfo.getNewsTitle().trim())){
            builder.append(" AND title like '%"+newsSearchInfo.getNewsTitle()+"%'");
        }
        if (newsSearchInfo.getStartTime()!=null&&!"".equals(newsSearchInfo.getStartTime().trim())){
            builder.append(" AND date > '"+newsSearchInfo.getStartTime()+"'");
        }
        if (newsSearchInfo.getEndTime()!=null&&!"".equals(newsSearchInfo.getEndTime().trim())){
            builder.append(" AND date < '"+newsSearchInfo.getEndTime()+"'");
        }
        return builder.toString();
    }



    public List<News> findNewsBySearch(NewsSearchInfo newsSearchInfo,Page page) {
        String sql = "select * from news where 1 = 1 AND toTop = 0";
        String s = buildSQL(newsSearchInfo, sql);
        s += " limit "+(page.getCurrentPage()-1)*page.getMaxsize()+","+page.getMaxsize();
        System.out.println(s);
        List<News> list = ClassReflictionForDaoUtil.getEntities(News.class,Jdbc_Utils.getResultSet(s));
        return list;
    }

    public int findNewsCountBySearch(NewsSearchInfo newsSearchInfo) {
        int count=0;
        String sql = "select count(*) nums from news where 1=1 AND toTop = 0";
        String s = buildSQL(newsSearchInfo, sql);
        ResultSet resultSet = Jdbc_Utils.getResultSet(s);
        try {
            if (!resultSet.isBeforeFirst()){
                resultSet.beforeFirst();
            }
            while (resultSet.next()){
                count = resultSet.getInt("nums");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean setNewsToTop(News news) {
        if (news.getToTop()==0){
            news.setToTop(1);
        }else {
            news.setToTop(0);
        }

        String news1 = ClassReflictionForDaoUtil.updateSQL(news, "news");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(news1);
        boolean execute = false;
        try {
            execute = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return execute;
    }

    public List<News> getToTopNews() {
        List<News> list = ClassReflictionForDaoUtil.getEntities(News.class,Jdbc_Utils.getResultSet("select * from news where status =1 AND toTop = 1"));
        return list;
    }
}
