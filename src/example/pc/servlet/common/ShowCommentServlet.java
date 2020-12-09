package example.pc.servlet.common;

import com.alibaba.fastjson.JSON;
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
import java.util.List;

@WebServlet("/back/showcomment")
public class ShowCommentServlet extends HttpServlet {
    ICommentService service = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String maxsize = req.getParameter("maxsize");
        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxsize(Integer.valueOf(maxsize));
        List<Comment> comments = service.getShowableCommonByPage(page);
        String s = JSON.toJSONString(comments);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
