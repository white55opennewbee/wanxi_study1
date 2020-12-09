package example.pc.dao;

import example.pc.dto.ProductionSearchInfo;
import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Page;
import example.pc.entity.Production;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductionDao {


    public List<Production> getAllShowableProductions(){
        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet("select * from production where status = 1"));
        return entities;
    }


//
//    public List<Production> getAllProductions(){
//        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet("select * from production"));
//        return entities;
//    }



    public void updateProduction(Production production){
        String update = ClassReflictionForDaoUtil.updateSQL(production, "production");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(update);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int id){
        Production production = new Production();
        production.setId(id);
        production.setStatus(0);
        updateProduction(production);
    }


    public void addProduction(Production production) {
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(ClassReflictionForDaoUtil.insertSQL(production,"production"));
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getProductionNums(){
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement("select count(*) from production where status = 1");
        ResultSet resultSet = null;
        try {
             resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
//
//    public List<Production> getAllProductionByPage(Page page){
//        String sql = "select * from production limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize();
//        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet(sql));
//        System.out.println(sql);
//        return entities;
//    }

    public List<Production> getShowableProductionByPage(Page page){
        String sql = "select * from production where status = 1 limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize();
        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet(sql));
        System.out.println(sql);
        return entities;
    }

    public Production getSingleProductions(String id) {
        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet("select * from production where id = " +id));
        return entities.get(0);

    }

    public Integer findProdcutionCountBySearch(ProductionSearchInfo productionSearchInfo){
        String headsql = "select count(*) nums from production where status = 1 ";
        String sql = buildSearchSQL(productionSearchInfo,headsql);
        System.out.println(sql);
        int num = 0 ;
        ResultSet resultSet = Jdbc_Utils.getResultSet(sql);
        try {
            if (resultSet.isBeforeFirst()){
                while (resultSet.next()){
                   num =  resultSet.getInt("nums");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }




    public String buildSearchSQL(ProductionSearchInfo productionSearchInfo,String headSQL){
        StringBuilder sql = new StringBuilder(headSQL);
        if (productionSearchInfo.getSearchByName()!=null&&!productionSearchInfo.getSearchByName().trim().equals("")){
            sql.append(" AND productionName like '%"+productionSearchInfo.getSearchByName()+"%'");
        }
        if (productionSearchInfo.getLowestPrice()!=null&&!productionSearchInfo.getLowestPrice().trim().equals("")){
            sql.append(" AND price > "+productionSearchInfo
                    .getLowestPrice());
        }
        if (productionSearchInfo.getMaxPrice()!=null&&!productionSearchInfo.getMaxPrice().trim().equals("")){
            System.out.println(productionSearchInfo.getMaxPrice());
            sql.append(" AND price < "+productionSearchInfo.getMaxPrice());
        }
        if (productionSearchInfo.getSelection()!=null&&!productionSearchInfo.getSelection().trim().equals("全部")){
            sql.append(" AND type like '%"+productionSearchInfo.getSelection()+"%'");
        }
        return sql.toString();
    }


    public List<Production> findProductionBySearch(ProductionSearchInfo productionSearchInfo,Page page) {
        String headSQL = "select * from production where status = 1  ";
        String sql = buildSearchSQL(productionSearchInfo,headSQL);
        sql += "limit "+(page.getCurrentPage()-1)*page.getMaxsize()+" , "+page.getMaxsize();
        System.out.println(sql);
        List<Production> entities = ClassReflictionForDaoUtil.getEntities(Production.class, Jdbc_Utils.getResultSet(sql));
        return entities;
    }
}
