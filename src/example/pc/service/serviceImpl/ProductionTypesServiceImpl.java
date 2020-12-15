package example.pc.service.serviceImpl;

import example.pc.dao.impl.ProductionTypesDao;
import example.pc.service.IProductionTypesService;

import java.util.List;

public class ProductionTypesServiceImpl implements IProductionTypesService {
    ProductionTypesDao productionTypesDao = new ProductionTypesDao();
    @Override
    public List<String> getAllProductionTypes(){
        return productionTypesDao.getAllProductionTypes();
    }
}
