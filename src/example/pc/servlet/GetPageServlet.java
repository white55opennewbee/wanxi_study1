package example.pc.servlet;


import com.alibaba.fastjson.JSON;
import example.pc.service.ICommentService;
import example.pc.service.INewsService;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.CommentServiceImpl;
import example.pc.service.serviceImpl.NewsServiceImpl;
import example.pc.service.serviceImpl.ProductionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getpage")
public class GetPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        String pagetype = req.getParameter("Pagetype");
        if ("production".equals(pagetype)){
            IProductionService service  = new ProductionServiceImpl();
            page = service.getPages();
        }else if ("news".equals(pagetype)){
            INewsService service = new NewsServiceImpl();
            page = service.getPages();
        }else if ("comment".equals(pagetype)){
            ICommentService service = new CommentServiceImpl();
            page = service.getPages();
        }
        String s = JSON.toJSONString(page);
        System.out.println(s);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
