package example.pc.servlet.common;

import com.alibaba.fastjson.JSON;
import example.pc.dto.CommentSearchInfo;
import example.pc.entity.Comment;
import example.pc.entity.Page;
import example.pc.service.ICommentService;
import example.pc.service.serviceImpl.CommentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/back/searchcomments")
public class SearchCommentsServlet extends HttpServlet {
    ICommentService service = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();

        String name = req.getParameter("name");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String currentPage = req.getParameter("currentPage");
        String maxSize = req.getParameter("maxSize");
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxsize(Integer.valueOf(maxSize));
        CommentSearchInfo searchInfo = new CommentSearchInfo();
        searchInfo.setName(name);
        searchInfo.setStartTime(startTime);
        searchInfo.setEndTime(endTime);
        List<Comment> list = service.getSearchCommentsByPage(searchInfo,page);
        int count = service.getPageCountBySearch(searchInfo);
        resp.setContentType("application/json;charset=utf-8");
        map.put("comments",list);
        map.put("counts",count);
        String s = JSON.toJSONString(map);

        System.out.println(s);
        resp.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
