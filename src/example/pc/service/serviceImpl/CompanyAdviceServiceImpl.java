package example.pc.service.serviceImpl;

import example.pc.dao.impl.CompanyAdviceDao;
import example.pc.entity.CompanyAdvance;
import example.pc.service.ICompanyAdviceService;

import java.util.List;

public class CompanyAdviceServiceImpl implements ICompanyAdviceService {
    CompanyAdviceDao companyAdviceDao = new CompanyAdviceDao();
    @Override
    public List<CompanyAdvance> getAdvances() {

        List<CompanyAdvance> list = companyAdviceDao.getAllShowableCompanyAdvice();
        return list;
    }
}
