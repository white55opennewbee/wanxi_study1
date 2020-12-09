package example.pc.servlet.company;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Company;
import example.pc.service.ICompanyService;
import example.pc.service.serviceImpl.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCompany")
public class GetCompanyServlet extends HttpServlet {
    ICompanyService service = new CompanyServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company companyInfo = service.getCompanyInfo();
        String s = JSON.toJSONString(companyInfo);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
