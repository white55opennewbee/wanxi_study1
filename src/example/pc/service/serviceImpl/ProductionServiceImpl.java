package example.pc.service.serviceImpl;

import example.pc.Utils.JedisUtiles;
import example.pc.dao.IProductionMapper;
import example.pc.dto.ProductionSearchInfo;
import example.pc.dao.impl.ProductionDao;
import example.pc.entity.Page;
import example.pc.entity.Production;
import example.pc.service.IProductionService;
import redis.clients.jedis.Jedis;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductionServiceImpl implements IProductionService {
    IProductionMapper productionDao = new ProductionDao();
    Jedis jedis = JedisUtiles.getJedis();

    @Override
    public List<Production> getProductions() {
        List<Production> list;

        list = productionDao.getAllShowableProductions();
        return list;
    }

    @Override
    public void addProduction(Production production) {
        delRedisMsg();
        productionDao.addProduction(production);
    }

    @Override
    public void deleteProduction(int id) {
        delRedisMsg();
        productionDao.delete(id);
    }

    @Override
    public void updateProduction(Production production) {
        delRedisMsg();
        productionDao.updateProduction(production);
    }

    private void delRedisMsg() {
        if (jedis.exists("WANXI_STUDY:PRODUCTION:ID")) {
            jedis.del("WANXI_STUDY:PRODUCTION:ID",
                    "WANXI_STUDY:PRODUCTION:PRODUCTIONNAME",
                    "WANXI_STUDY:PRODUCTION:PRICE",
                    "WANXI_STUDY:PRODUCTION:PRODUCTIONIMGURL",
                    "WANXI_STUDY:PRODUCTION:NUMBER",
                    "WANXI_STUDY:PRODUCTION:TYPE",
                    "WANXI_STUDY:PRODUCTION:TRADETIME",
                    "WANXI_STUDY:PRODUCTION:INCOUNTRYPLACE",
                    "WANXI_STUDY:PRODUCTION:EXPORTPLACE"
            );
        }
        jedis.close();
    }


    @Override
    public List<Production> getProductionByPage(Page page) {
        List<Production> list = new ArrayList<>();
        if (page.getCurrentPage() == 1) {
            if (jedis.exists("WANXI_STUDY:PRODUCTION:ID")) {
                System.out.println("PRODUCTIONINFO FROM REDIS");
                for (int i = 0; i < jedis.llen("WANXI_STUDY:PRODUCTION:ID"); i++) {
                    Production production = new Production();
                    production.setId(Integer.valueOf(jedis.lindex("WANXI_STUDY:PRODUCTION:ID", i)));
                    production.setProductionName(jedis.lindex("WANXI_STUDY:PRODUCTION:PRODUCTIONNAME", i));
                    production.setPrice(jedis.lindex("WANXI_STUDY:PRODUCTION:PRICE", i));
                    production.setProductionImgUrl(jedis.lindex("WANXI_STUDY:PRODUCTION:PRODUCTIONIMGURL", i));
                    production.setNumber(Integer.valueOf(jedis.lindex("WANXI_STUDY:PRODUCTION:NUMBER", i)));
                    production.setType(jedis.lindex("WANXI_STUDY:PRODUCTION:TYPE", i));
                    production.setTradeTime(jedis.lindex("WANXI_STUDY:PRODUCTION:TRADETIME", i));
                    production.setIncountryPlace(jedis.lindex("WANXI_STUDY:PRODUCTION:INCOUNTRYPLACE", i));
                    production.setExportPlace(jedis.lindex("WANXI_STUDY:PRODUCTION:EXPORTPLACE", i));
                    list.add(production);
                }
            } else {
                list = productionDao.getShowableProductionByPage(page);
                System.out.println("PRODUCTIONINFO FROM JDBC");
                list.forEach(item -> {
                    jedis.rpush("WANXI_STUDY:PRODUCTION:ID", item.getId() + "");
                    jedis.rpush("WANXI_STUDY:PRODUCTION:PRODUCTIONNAME", item.getProductionName());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:PRICE", item.getPrice());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:PRODUCTIONIMGURL", item.getProductionImgUrl());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:NUMBER", item.getNumber() + "");
                    jedis.rpush("WANXI_STUDY:PRODUCTION:TYPE", item.getType());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:TRADETIME", item.getTradeTime());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:INCOUNTRYPLACE", item.getIncountryPlace());
                    jedis.rpush("WANXI_STUDY:PRODUCTION:EXPORTPLACE", item.getExportPlace());
                });
            }
        } else {
            list = productionDao.getShowableProductionByPage(page);
        }

        jedis.close();
        return list;
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
    public List<Production> findProductionBySearch(ProductionSearchInfo productionSearchInfo, Page page) {
        Map map = new HashMap();
        map.put("productionSearchInfo", productionSearchInfo);
        map.put("page", page);
        List<Production> productions = productionDao.findProductionBySearch(map);
        return productions;
    }

    @Override
    public int getPagesBySearch(ProductionSearchInfo productionSearchInfo) {
        return productionDao.findProdcutionCountBySearch(productionSearchInfo);

    }
}
