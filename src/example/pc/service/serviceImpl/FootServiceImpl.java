package example.pc.service.serviceImpl;

import example.pc.dao.FootDao;
import example.pc.entity.FootLogo;
import example.pc.service.IFootService;

import java.util.List;

public class FootServiceImpl implements IFootService {

    FootDao footDao = new FootDao();
    public List<FootLogo> getFootLogo(){

        List<FootLogo> logos = footDao.getAllFoot();
        for (FootLogo logo:logos){
            logo.setFootImgurl("img/"+logo.getFootImgurl());
        }
        return logos;
    }
}
