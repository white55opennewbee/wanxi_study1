package example.pc.service;

import example.pc.dto.ProductionSearchInfo;
import example.pc.entity.Page;
import example.pc.entity.Production;

import java.util.List;

public interface IProductionService {
    List<Production> getProductions();
    void addProduction(Production production);
    void deleteProduction(int id);
    void updateProduction(Production production);
    List<Production> getProductionByPage(Page page);

    int getPages();

    Production getSingleProduction(String id);

    List<Production> findProductionBySearch(ProductionSearchInfo productionSearchInfo,Page page);

    int getPagesBySearch(ProductionSearchInfo productionSearchInfo);
}
