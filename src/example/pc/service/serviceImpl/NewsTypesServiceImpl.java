package example.pc.service.serviceImpl;

import example.pc.dao.impl.NewsTypesDao;
import example.pc.service.INewsTypesService;

import java.util.List;

public class NewsTypesServiceImpl implements INewsTypesService {
    NewsTypesDao newsTypesDao = new NewsTypesDao();
    @Override
    public List<String> getNewsAllTypes(){
        return newsTypesDao.getAllNewsTypes();
    }
}
