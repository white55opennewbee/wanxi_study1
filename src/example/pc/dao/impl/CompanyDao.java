package example.pc.dao.impl;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.ICompanyMapper;
import example.pc.entity.Company;
import org.apache.ibatis.session.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 * @author pc
 * @date 2020/12/12
 */
public class CompanyDao implements ICompanyMapper {

    @Override
    public void updateCompany(Company company) {
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        ICompanyMapper mapper = sqlsession.getMapper(ICompanyMapper.class);
        mapper.updateCompany(company);
    }

    @Override
    public List<Company> getCompany(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        ICompanyMapper mapper = sqlsession.getMapper(ICompanyMapper.class);
        List<Company> company = mapper.getCompany();
        return company;
    }

}
