package example.pc.servlet;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Nav;
import example.pc.service.ICompanyService;
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

@WebServlet("/aboutus")
public class AboutUsServlet extends HttpServlet {
    INavService navService = new NavServiceImpl();
    ICompanyService companyService = new CompanyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        Nav nav = navService.getSingleNav("关于我们");
        map.put("aboutUsInfo",companyService.getCompanyInfo().getAboutUsIntroduce() );
        map.put("pagename", nav.getTitle());
        map.put("pageusname", nav.getUsPagename());
        resp.setContentType("application/json;charset=utf-8");
        String s = JSON.toJSONString(map);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
