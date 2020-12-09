package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.Company;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CompanyDao {


    public void updateCompany(Company company){
        String update = ClassReflictionForDaoUtil.updateSQL(company, "company");
        PreparedStatement preparedStatement = Jdbc_Utils.getPreparedStatement(update);
        try {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Object> getCompany(){
        List<Object> entities = ClassReflictionForDaoUtil.getEntities(Company.class, Jdbc_Utils.getResultSet("select * from company"));
        return entities;
    }

    public void deleteCompany(int id){
        Company company = new Company();
        company.setId(id);
        company.setStatus(0);
        updateCompany(company);
    }
}
