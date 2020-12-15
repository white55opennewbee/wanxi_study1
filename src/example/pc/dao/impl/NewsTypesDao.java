package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.INewTypesMapper;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pc
 * @date 2020/12/12
 */
public class NewsTypesDao implements INewTypesMapper {
    @Override
    public List<String> getAllNewsTypes(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        INewTypesMapper mapper = sqlsession.getMapper(INewTypesMapper.class);
        List<String> allNewsTypes = mapper.getAllNewsTypes();
        return allNewsTypes;
    }
}
