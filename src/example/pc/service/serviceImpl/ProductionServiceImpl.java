package example.pc.service.serviceImpl;

import example.pc.dto.ProductionSearchInfo;
import example.pc.dao.ProductionDao;
import example.pc.entity.Page;
import example.pc.entity.Production;
import example.pc.service.IProductionService;


import java.util.List;

public class ProductionServiceImpl implements IProductionService {
    ProductionDao productionDao = new ProductionDao();


    public List<Production> getProductions() {
        List<Production> list;

        list = productionDao.getAllShowableProductions();
        return list;
    }

    public void addProduction(Production production){
        productionDao.addProduction(production);
    }

    @Override
    public void deleteProduction(int id) {
        productionDao.delete(id);
    }

    @Override
    public void updateProduction(Production production) {
        productionDao.updateProduction(production);
    }

    @Override
    public List<Production> getProductionByPage(Page page) {
        List<Production> showableProductionByPage = productionDao.getShowableProductionByPage(page);
        return showableProductionByPage;
    }

    @Override
    public int getPages() {
        int productionNums = productionDao.getProductionNums();
        return productionNums;
    }

    @Override
    public Production getSingleProduction(String id) {
        Production Productions = productionDao.getSingleProductions(id);
        return Productions;
    }

    @Override
    public List<Production> findProductionBySearch(ProductionSearchInfo productionSearchInfo,Page page) {
       List<Production> productions =  productionDao.findProductionBySearch(productionSearchInfo,page);
       return productions;
    }

    @Override
    public int getPagesBySearch(ProductionSearchInfo productionSearchInfo) {
       return productionDao.findProdcutionCountBySearch(productionSearchInfo);

    }
}
