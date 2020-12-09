package example.pc.dao;

import example.pc.dto.CommentSearchInfo;
import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Comment;
import example.pc.entity.Page;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommentDao {

    public List<Comment> getAllShowableCommons(){
        List<Comment> entities = ClassReflictionForDaoUtil.getEntities(Comment.class, Jdbc_Utils.getResultSet("select * from common where status = 1"));
        return entities;
    }


    public List<Comment> getAllShowableCommonsByPage(Page page){
        List<Comment> entities = ClassReflictionForDaoUtil.getEntities(Comment.class, Jdbc_Utils.getResultSet("select * from common where status = 1 limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize()));
        return entities;
    }


    public List<Comment> getAllCommons(){
        List<Comment> entities = ClassReflictionForDaoUtil.getEntities(Comment.class, Jdbc_Utils.getResultSet("select * from common"));
        return entities;
    }




    public void addComment(Comment comment){
        String addSql = ClassReflictionForDaoUtil.insertSQL(comment, "common");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(addSql);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateComment(Comment comment){
        ClassReflictionForDaoUtil.updateSQL(comment,"common");
        String update = ClassReflictionForDaoUtil.updateSQL(comment, "common");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(update);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(Comment comment){
        updateComment(comment);
    }

    public int getPages() {
        int nums = 0;
        ResultSet resultSet = Jdbc_Utils.getResultSet("select count(*) from common");
        try {

            if(resultSet.next()){
                nums = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nums;
    }



    private String  buildSQL(CommentSearchInfo searchInfo,String orgSQL){
        StringBuilder builder = new StringBuilder(orgSQL);
        if (searchInfo.getName()!=null&&!"".equals(searchInfo.getName().trim())){
            builder.append(" AND commonUsername like '%"+searchInfo.getName()+"%' ");
        }
        if (searchInfo.getStartTime()!=null&&!"".equals(searchInfo.getEndTime().trim())){
            builder.append(" AND commonTime > '"+searchInfo.getStartTime()+"'");
        }
        if (searchInfo.getEndTime()!=null&&!"".equals(searchInfo.getEndTime().trim())){
            builder.append(" AND commonTime < '"+ searchInfo.getEndTime()+"'");
        }
        return builder.toString();
    }



    public List<Comment> getSearchComments(CommentSearchInfo searchInfo, Page page) {
        String sql = "select * from common where status = 1 ";
        sql = buildSQL(searchInfo,sql);
        sql += " limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize();
        System.out.println(sql);
        List<Comment> entities = ClassReflictionForDaoUtil.getEntities(Comment.class, Jdbc_Utils.getResultSet(sql));
        return entities;
    }

    public int getPagesCountBySearch(CommentSearchInfo commentSearchInfo) {
        String sql = "select count(*) allcounts from common where status = 1 ";
        sql = buildSQL(commentSearchInfo,sql);
        int counts = 0;
        ResultSet resultSet = Jdbc_Utils.getResultSet(sql);
        try {
            while (resultSet.next()){
               counts =  resultSet.getInt("allcounts");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return counts;
    }
}
