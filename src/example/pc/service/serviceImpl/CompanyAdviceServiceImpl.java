package example.pc.service.serviceImpl;

import example.pc.dao.CompanyAdviceDao;
import example.pc.entity.CompanyAdvance;
import example.pc.service.ICompanyAdviceService;

import java.util.List;

public class CompanyAdviceServiceImpl implements ICompanyAdviceService {
    CompanyAdviceDao companyAdviceDao = new CompanyAdviceDao();

    public List<CompanyAdvance> getAdvances() {

        List<CompanyAdvance> list = companyAdviceDao.getAllShowableCompany();
        for (CompanyAdvance advance:list){
            advance.setImgUrl("img/"+advance.getImgUrl());
        }
        return list;
    }
}
