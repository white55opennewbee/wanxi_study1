package example.pc.service.serviceImpl;

import example.pc.dao.ProductionTypesDao;
import example.pc.service.IProductionTypesService;

import java.util.List;

public class ProductionTypesServiceImpl implements IProductionTypesService {
    ProductionTypesDao productionTypesDao = new ProductionTypesDao();
    public List<String> getAllProductionTypes(){
        return productionTypesDao.getAllNewsTypes();
    }
}
