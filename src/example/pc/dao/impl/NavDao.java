package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.INavMapper;
import example.pc.entity.Nav;
import org.apache.ibatis.session.SqlSession;

import java.lang.invoke.VarHandle;
import java.util.List;

public class NavDao implements INavMapper {

    @Override
    public List<Nav> getNavs(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INavMapper mapper = sqlsession.getMapper(INavMapper.class);
        List<Nav> navs = mapper.getNavs();
        return navs;
    }

}
