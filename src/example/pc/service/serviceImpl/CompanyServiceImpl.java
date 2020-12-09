package example.pc.service.serviceImpl;

import example.pc.dao.CompanyDao;
import example.pc.entity.Company;
import example.pc.service.ICompanyService;

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {
    CompanyDao companyDao = new CompanyDao();
    public Company getCompanyInfo(){

        List<Object> companys = companyDao.getCompany();
        Company company = (Company) companys.get(0);
        company.setImgUrl("img/"+company.getImgUrl());
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }
}
