package example.pc.servlet;

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
@WebServlet("/callus")
public class CallUsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICompanyService companyService = new CompanyServiceImpl();
        INavService navService = new NavServiceImpl();

        Nav nav = navService.getSingleNav("联系我们");


        req.setAttribute("desc",companyService.getCompanyInfo().getCallUsIntroduce());
        req.setAttribute("pagename",nav.getTitle());
        System.out.println(nav.getUsPagename());
        req.setAttribute("pageusname",nav.getUsPagename());
        req.getRequestDispatcher("jsp/Callus.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
