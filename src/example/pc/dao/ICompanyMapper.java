package example.pc.dao;


import example.pc.entity.Company;


import java.util.List;

/**
 * @author pc
 * @date 2020/12/12
 */
public interface ICompanyMapper {
    void updateCompany(Company company);
    List<Company> getCompany();
}
