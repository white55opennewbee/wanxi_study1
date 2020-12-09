package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Nav;
import example.pc.entity.Page;
import example.pc.service.INavService;
import example.pc.service.INewsService;
import example.pc.service.INewsTypesService;
import example.pc.service.serviceImpl.NavServiceImpl;
import example.pc.service.serviceImpl.NewsServiceImpl;
import example.pc.service.serviceImpl.NewsTypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.MarshalledObject;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    INewsService newsService = new NewsServiceImpl();
    INavService navService = new NavServiceImpl();
    INewsTypesService newsTypesService = new NewsTypesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        Page page = new Page();
        System.out.println(req.getParameter("currentPage"));
        page.setCurrentPage(Integer.valueOf(req.getParameter("currentPage")));
        page.setMaxsize(Integer.valueOf(req.getParameter("maxSize")));
        map.put("news", newsService.getNewsByPage(page));
        Nav nav = navService.getSingleNav("新闻中心");
        map.put("pagename",nav.getTitle());
        map.put("pageusname",nav.getUsPagename());
        map.put("newstypes", newsTypesService.getNewsAllTypes());
        resp.setContentType("application/json;charset=utf-8");
        String s = JSON.toJSONString(map);
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
