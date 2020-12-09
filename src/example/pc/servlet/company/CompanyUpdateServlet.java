package example.pc.servlet.company;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import example.pc.entity.Company;
import example.pc.service.ICompanyService;

import example.pc.service.serviceImpl.CompanyServiceImpl;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/back/updateCompany")
public class CompanyUpdateServlet extends HttpServlet {
    ICompanyService service = new CompanyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = IOUtils.toString(req.getInputStream(), "UTF-8");
        System.out.println(s);
        JSONObject jsonObject = null;
        jsonObject = JSON.parseObject(s);
        Company company = jsonObject.toJavaObject(Company.class);

        service.updateCompany(company);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
