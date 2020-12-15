package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.IProductionTypesMapper;
import org.apache.ibatis.session.SqlSession;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author pc
 * @date 2020/12/11
 */
public class ProductionTypesDao implements IProductionTypesMapper {

    @Override
    public List<String> getAllProductionTypes() {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        IProductionTypesMapper mapper = sqlsession.getMapper(IProductionTypesMapper.class);
        List<String> types = mapper.getAllProductionTypes();
        return types;
    }
}
