package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Nav;

import java.util.List;

public class NavDao {


    public List<Nav> getNavs(){
        List<Nav> entities = ClassReflictionForDaoUtil.getEntities(Nav.class, Jdbc_Utils.getResultSet("select * from nav"));
        return entities;

    }

}
