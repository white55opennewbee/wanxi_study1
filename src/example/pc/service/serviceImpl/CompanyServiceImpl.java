package example.pc.service.serviceImpl;

import example.pc.Utils.JedisUtiles;
import example.pc.dao.impl.CompanyDao;
import example.pc.entity.Company;
import example.pc.service.ICompanyService;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author pc
 * @date 2020/12/12
 */
public class CompanyServiceImpl implements ICompanyService {
    private static Object object = new Object();
    Jedis jedis = JedisUtiles.getJedis();
    CompanyDao companyDao = new CompanyDao();

    @Override
    public Company getCompanyInfo() {
        final Company[] company = {new Company()};
        for (int i=0;i<500;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    company[0] = getData();
                    System.out.println(Thread.currentThread().getName()+"读取Redis");
                }
            },"线程"+i).start();
        }
        return company[0];
    }

    public synchronized Company getData(){
        Company company = new Company();
        if (jedis.exists("WANXI_STUDY:COMPANY:ID")) {
            System.out.println("COMPANY FROM REDIS");
            company.setId(Integer.valueOf(jedis.get("WANXI_STUDY:COMPANY:ID")));
            company.setImgUrl(jedis.get("WANXI_STUDY:COMPANY:IMGURL"));
            company.setCompanyName(jedis.get("WANXI_STUDY:COMPANY:COMPANYNAME"));
            company.setCallUsIntroduce(jedis.get("WANXI_STUDY:COMPANY:CALLUSINTRODUCE"));
            company.setAboutUsIntroduce(jedis.get("WANXI_STUDY:COMPANY:ABOUTUSINTRODUCE"));
            company.setSymbol(jedis.get("WANXI_STUDY:COMPANY:SYMBOL"));
        } else {
            company = companyDao.getCompany().get(0);
            System.out.println("COMPANY FROM JDBC");
            jedis.set("WANXI_STUDY:COMPANY:ID", company.getId() + "");
            jedis.set("WANXI_STUDY:COMPANY:IMGURL", company.getImgUrl());
            jedis.set("WANXI_STUDY:COMPANY:COMPANYNAME", company.getCompanyName());
            jedis.set("WANXI_STUDY:COMPANY:CALLUSINTRODUCE", company.getCallUsIntroduce());
            jedis.set("WANXI_STUDY:COMPANY:ABOUTUSINTRODUCE", company.getAboutUsIntroduce());
            jedis.set("WANXI_STUDY:COMPANY:SYMBOL", company.getSymbol());
        }
        jedis.close();
        return company;
    }


    @Override
    public void updateCompany(Company company) {

        if (jedis.exists("WANXI_STUDY:COMPANY:ID")) {
            jedis.del("WANXI_STUDY:COMPANY:ID",
                    "WANXI_STUDY:COMPANY:IMGURL",
                    "WANXI_STUDY:COMPANY:COMPANYNAME",
                    "WANXI_STUDY:COMPANY:CALLUSINTRODUCE",
                    "WANXI_STUDY:COMPANY:ABOUTUSINTRODUCE",
                    "WANXI_STUDY:COMPANY:SYMBOL");
        }
        companyDao.updateCompany(company);
        jedis.close();
    }


}
