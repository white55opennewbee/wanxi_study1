package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.IFootMapper;
import example.pc.entity.FootLogo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
/**
 * @author pc
 * @date 2020/12/12
 */
public class FootDao implements IFootMapper {
    @Override
    public List<FootLogo> getAllFoot(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        IFootMapper mapper = sqlsession.getMapper(IFootMapper.class);
        List<FootLogo> allFoot = mapper.getAllFoot();
        return allFoot;
    }


}
