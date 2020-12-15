package example.pc.service.serviceImpl;

import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.JedisUtiles;
import example.pc.dao.impl.NavDao;
import example.pc.entity.Nav;
import example.pc.service.INavService;
import jdk.swing.interop.SwingInterOpUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;

public class NavServiceImpl implements INavService {
    NavDao navDao = new NavDao();
    Jedis jedis = JedisUtiles.getJedis();

    @Override
    public List<Nav> getNavs() {
        List<Nav> list = new ArrayList();

        if (jedis.exists("WANXI_STUDY:NAV:ID")) {
            System.out.println("NAV FROM REDIS");
            for (int i = 0; i < jedis.llen("WANXI_STUDY:NAV:ID"); i++) {
                list.add(buildNav(i));

            }
        } else {
            list = navDao.getNavs();
            System.out.println("NAV FROM JDBC");
            for (Nav nav : list) {
                jedis.rpush("WANXI_STUDY:NAV:ID", nav.getId() + "");
                jedis.rpush("WANXI_STUDY:NAV:USPAGENAME", nav.getUsPagename());
                jedis.rpush("WANXI_STUDY:NAV:TITLE", nav.getTitle());
                jedis.rpush("WANXI_STUDY:NAV:HREF", nav.getHref());
                jedis.rpush("WANXI_STUDY:NAV:DESCRIBE", nav.getDescribe());
            }
            System.out.println("jdbc");
        }
        jedis.close();
        return list;
    }
    private Nav buildNav(int i){
        Nav nav = new Nav();
        nav.setId(Integer.valueOf(jedis.lindex("WANXI_STUDY:NAV:ID", i)));
        nav.setUsPagename(jedis.lindex("WANXI_STUDY:NAV:USPAGENAME", i));
        nav.setTitle(jedis.lindex("WANXI_STUDY:NAV:TITLE", i));
        nav.setHref(jedis.lindex("WANXI_STUDY:NAV:HREF", i));
        nav.setDescribe(jedis.lindex("WANXI_STUDY:NAV:DESCRIBE", i));
        return nav;
    }


    @Override
    public Nav getSingleNav(String key) {
        Nav nav = new Nav();
        if (jedis.exists("WANXI_STUDY:NAV:TITLE")) {
            List<String> lrange = jedis.lrange("WANXI_STUDY:NAV:TITLE", 0, -1);
            for (int i = 0; i < lrange.size(); i++) {
                if (jedis.lindex("WANXI_STUDY:NAV:TITLE", i).equals(key)){
                    nav = buildNav(i);
                    break;
                }
            }
        }else{
            List<Nav> navs = getNavs();
            for (Nav nv : navs) {
                if (nv.getTitle().equals(key)) {
                    nav = nv;
                    break;
                }
            }
        }
        jedis.close();
        return nav;

    }
}
