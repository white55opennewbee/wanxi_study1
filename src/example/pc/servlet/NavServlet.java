package example.pc.servlet;

import com.alibaba.fastjson.JSON;
import example.pc.service.INavService;
import example.pc.service.serviceImpl.CompanyServiceImpl;
import example.pc.service.serviceImpl.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/nav")
public class NavServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        INavService navService = new NavServiceImpl();
        CompanyServiceImpl companyService = new CompanyServiceImpl();
        map.put("navList", navService.getNavs());
        map.put("companyLogo",companyService.getCompanyInfo());
        String s = JSON.toJSONString(map);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
