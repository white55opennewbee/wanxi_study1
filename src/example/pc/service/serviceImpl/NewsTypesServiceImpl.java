package example.pc.service.serviceImpl;

import example.pc.dao.NewsTypesDao;
import example.pc.service.INewsTypesService;

import java.util.List;

public class NewsTypesServiceImpl implements INewsTypesService {
    NewsTypesDao newsTypesDao = new NewsTypesDao();
    public List<String> getNewsAllTypes(){
        return newsTypesDao.getAllNewsTypes();
    }
}
