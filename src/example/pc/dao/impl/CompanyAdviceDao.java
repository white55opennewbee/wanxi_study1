package example.pc.dao.impl;

import example.pc.Utils.Mybatis_Utils;
import example.pc.dao.ICompanyAdviceMapper;
import example.pc.entity.CompanyAdvance;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CompanyAdviceDao implements ICompanyAdviceMapper {
    @Override
    public List<CompanyAdvance> getAllShowableCompanyAdvice(){
        SqlSession sqlsession = Mybatis_Utils.getSqlsession();
        ICompanyAdviceMapper mapper = sqlsession.getMapper(ICompanyAdviceMapper.class);
        List<CompanyAdvance> allShowableCompanyAdvice = mapper.getAllShowableCompanyAdvice();
        return allShowableCompanyAdvice;
    }
}
