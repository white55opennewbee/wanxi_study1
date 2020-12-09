package example.pc.servlet.news;

import com.alibaba.fastjson.JSONObject;
import example.pc.entity.News;
import example.pc.service.INewsService;
import example.pc.service.serviceImpl.NewsServiceImpl;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/back/refreshnews")
public class RefreshNewsServlet extends HttpServlet {
    INewsService service = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = IOUtils.toString(req.getInputStream(), "UTF-8");
        News news = JSONObject.parseObject(json, News.class);
        news.setDate(null);
        System.out.println(news);
        service.updateNews(news);
        resp.getWriter().write("true");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
