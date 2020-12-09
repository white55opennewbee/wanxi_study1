package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
import example.pc.Utils.DateTransfer;
import example.pc.entity.News;
import example.pc.service.INewsService;
import example.pc.service.serviceImpl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/getsinglenews")
public class GetSingleProductionServlet extends HttpServlet {
    INewsService service = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        News news = service.getNewsById(Integer.valueOf(id));
        String s = JSON.toJSONString(news);
        System.out.println(s);
        resp.setContentType("application/json:charset = utf-8");
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
