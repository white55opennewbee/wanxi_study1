package example.pc.service;

import example.pc.entity.Company;

public interface ICompanyService{
     Company getCompanyInfo();

    void updateCompany(Company company);
}
