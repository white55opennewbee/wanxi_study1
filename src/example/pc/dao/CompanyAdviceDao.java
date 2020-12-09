package example.pc.dao;

import example.pc.Utils.ClassReflictionForDaoUtil;
import example.pc.Utils.Jdbc_Utils;
import example.pc.entity.CompanyAdvance;


import java.util.List;

public class CompanyAdviceDao {


    public List<CompanyAdvance> getAllShowableCompany(){
        List<CompanyAdvance> entities = ClassReflictionForDaoUtil.getEntities(CompanyAdvance.class, Jdbc_Utils.getResultSet("select * from company_advice where status = 1"));
        return entities;
    }





}
