package example.pc.servlet.common;

import example.pc.service.ICommentService;
import example.pc.service.serviceImpl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    ICommentService service = new CommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("commonUsername");
        String email = req.getParameter("userEmail");
        String content = req.getParameter("userCommon");
        System.out.println(name+email+content);
        if (name!=null&&email!=null&&content!=null){
            service.addComment(name,email,content);
        }
        resp.getWriter().write("true");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
