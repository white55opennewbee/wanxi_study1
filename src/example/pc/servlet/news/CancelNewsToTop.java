package example.pc.servlet.news;

import example.pc.entity.News;
import example.pc.service.INewsService;
import example.pc.service.serviceImpl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/back/canceltotop")
public class CancelNewsToTop extends HttpServlet {
    INewsService service = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String toTop = req.getParameter("toTop");
        News news = new News();
        news.setToTop(Integer.valueOf(toTop));
        news.setId(Integer.valueOf(id));
        service.setToTop(news);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
