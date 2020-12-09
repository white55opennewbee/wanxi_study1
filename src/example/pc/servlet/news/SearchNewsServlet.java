package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
import example.pc.dto.NewsSearchInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/back/searchnews")
public class SearchNewsServlet extends HttpServlet {
    INewsService service = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();


        String newsType = req.getParameter("newsType");
        String newsTitle = req.getParameter("newsTitle");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String currentPage = req.getParameter("currentPage");
        String maxSize = req.getParameter("maxSize");
        System.out.println(newsType);
        System.out.println(newsTitle);
        System.out.println(startTime);

        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxsize(Integer.valueOf(maxSize));
        NewsSearchInfo newsSearchInfo = new NewsSearchInfo();
        newsSearchInfo.setEndTime(endTime);
        newsSearchInfo.setStartTime(startTime);
        newsSearchInfo.setNewsTitle(newsTitle);
        newsSearchInfo.setNewsType(newsType);
        List<News> list = service.findNewsBySearch(newsSearchInfo,page);
        map.put("news",list);
        int count = service.findNewsCountBySearch(newsSearchInfo);
        map.put("counts",count);
        resp.setContentType("application/json;charset = utf-8");
        String s = JSON.toJSONString(map);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
