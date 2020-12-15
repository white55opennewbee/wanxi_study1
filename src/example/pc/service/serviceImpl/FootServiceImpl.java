package example.pc.service.serviceImpl;

import example.pc.dao.impl.FootDao;
import example.pc.entity.FootLogo;
import example.pc.service.IFootService;

import java.util.List;

public class FootServiceImpl implements IFootService {

    FootDao footDao = new FootDao();
    @Override
    public List<FootLogo> getFootLogo(){

        List<FootLogo> logos = footDao.getAllFoot();
        return logos;
    }
}
