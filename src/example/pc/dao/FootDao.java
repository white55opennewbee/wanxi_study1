package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.FootLogo;

import java.util.List;

public class FootDao {

    public List<FootLogo> getAllFoot(){
        List<FootLogo> entities = ClassReflictionForDaoUtil.getEntities(FootLogo.class, Jdbc_Utils.getResultSet("select * from foot_img"));
        return entities;
    }


}
