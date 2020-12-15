package example.pc.dao.impl;

import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.IProductionMapper;
import example.pc.dto.ProductionSearchInfo;
import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Page;
import example.pc.entity.Production;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pc
 * @date 2020/12/11
 */
public class ProductionDao implements IProductionMapper {
    private SqlSession sqlSession = null;

    @Override
    public List<Production> getAllShowableProductions(){
        IProductionMapper mapper = getMapper();
        List<Production> allShowableProductions = mapper.getAllShowableProductions();
        return allShowableProductions;
    }

    @Override
    public void updateProduction(Production production){
        IProductionMapper mapper = getMapper();
        mapper.updateProduction(production);
        sqlSession.commit();
    }

    @Override
    public void delete(int id){
        IProductionMapper mapper = getMapper();
        mapper.delete(id);
        sqlSession.commit();
    }

    @Override
    public void addProduction(Production production) {
        IProductionMapper mapper = getMapper();
        mapper.addProduction(production);
        sqlSession.commit();
    }
    @Override
    public int getProductionNums(){
        IProductionMapper mapper = getMapper();
        int productionNums = mapper.getProductionNums();
        return productionNums;
    }

    @Override
    public List<Production> getShowableProductionByPage(Page page){
        IProductionMapper mapper = getMapper();
        List<Production> showableProductionByPage = mapper.getShowableProductionByPage(page);
        return showableProductionByPage;
    }
    @Override
    public Production getSingleProductions(String id) {
        IProductionMapper mapper = getMapper();
        Production singleProductions = mapper.getSingleProductions(id);
        return singleProductions;
    }
    @Override
    public Integer findProdcutionCountBySearch(ProductionSearchInfo productionSearchInfo){
        IProductionMapper mapper = getMapper();
        Integer prodcutionCountBySearch = mapper.findProdcutionCountBySearch(productionSearchInfo);
        return prodcutionCountBySearch;
    }
    @Override
    public List<Production> findProductionBySearch(Map map) {
        IProductionMapper mapper = getMapper();
        List<Production> productionBySearch = mapper.findProductionBySearch(map);
        return productionBySearch;
    }



    private IProductionMapper getMapper(){
        sqlSession = Mybatis_Utils.getSqlsession();
        IProductionMapper mapper = sqlSession.getMapper(IProductionMapper.class);
        return mapper;
    }
}
