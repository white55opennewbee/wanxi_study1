package example.pc.dao;

import example.pc.dto.ProductionSearchInfo;
import example.pc.entity.Page;
import example.pc.entity.Production;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IProductionMapper {
     /**
      * 获取所有status =1 的产品
      * @return List<Production>
      */
     List<Production> getAllShowableProductions();

     void updateProduction(Production production);
     void delete(int id);
     void addProduction(Production production);
     int getProductionNums();
     List<Production> getShowableProductionByPage(Page page);
     Production getSingleProductions(String id);
     Integer findProdcutionCountBySearch(@Param("productionSearchInfo") ProductionSearchInfo productionSearchInfo);
     List<Production> findProductionBySearch(Map map);
}
