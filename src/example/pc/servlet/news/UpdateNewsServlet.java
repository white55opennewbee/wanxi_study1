package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
import example.pc.entity.News;
import example.pc.entity.Page;
import example.pc.service.INewsService;
import example.pc.service.serviceImpl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/back/updatenews")
public class UpdateNewsServlet extends HttpServlet {
    INewsService newsService = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String maxSize = req.getParameter("maxSize");
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxsize(Integer.valueOf(maxSize));
        List<News> news = newsService.getNewsByPage(page);
        resp.setContentType("application/json;charset=utf-8");
        String result = JSON.toJSONString(news);
        resp.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
