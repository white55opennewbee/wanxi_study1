package example.pc.servlet;

import com.alibaba.fastjson.JSON;
import example.pc.service.ICompanyService;
import example.pc.service.IFootService;
import example.pc.service.serviceImpl.CompanyServiceImpl;
import example.pc.service.serviceImpl.FootServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/foot")
public class FootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        IFootService footService = new FootServiceImpl();
        ICompanyService companyService = new CompanyServiceImpl();

        map.put("logos", footService.getFootLogo());
        map.put("name",companyService.getCompanyInfo().getCompanyName());
        map.put("symbol",companyService.getCompanyInfo().getSymbol());

        resp.setContentType("application/json;charset=utf-8");
        String s = JSON.toJSONString(map);
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
