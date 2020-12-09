package example.pc.service.serviceImpl;

import example.pc.dao.NavDao;
import example.pc.entity.Nav;
import example.pc.service.INavService;

import java.util.ArrayList;
import java.util.List;

public class NavServiceImpl implements INavService {
    NavDao navDao = new NavDao();

    public List<Nav> getNavs(){
        List<Nav> list = new ArrayList();

        list = navDao.getNavs();
        return list;
    }

    public Nav getSingleNav(String key){
        List<Nav> navs = getNavs();
        Nav nav = null;
        for (Nav nv:navs){
            if (nv.getTitle().equals(key)){
                nav = nv;
                break;
            }
        }
        return nav;
    }




}
