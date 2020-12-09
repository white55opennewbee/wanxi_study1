package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
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

@WebServlet("/back/addnews")
public class AddNewsServlet extends HttpServlet {
    INewsService newsService = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = IOUtils.toString(req.getInputStream(), "UTF-8");
        News news = JSONObject.parseObject(json, News.class);
        newsService.addNews(news);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
