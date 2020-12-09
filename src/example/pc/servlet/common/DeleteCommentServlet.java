package example.pc.servlet.common;

import example.pc.entity.Comment;
import example.pc.service.ICommentService;
import example.pc.service.serviceImpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/back/deletecomment")
public class DeleteCommentServlet extends HttpServlet {
    ICommentService service = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Comment comment = new Comment();
        comment.setId(Integer.valueOf(id));
        comment.setCommonTime(null);
        comment.setStatus(0);
        service.deleteComment(comment);
        resp.getWriter().write("true");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
