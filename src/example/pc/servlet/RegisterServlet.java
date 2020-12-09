package example.pc.servlet;

import example.pc.entity.User;
import example.pc.service.IUserService;
import example.pc.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService service = new UserServiceImpl();
        String account = req.getParameter("account");
        String password = req.getParameter("userpass");
        String name = req.getParameter("name");
        String phnumber = req.getParameter("phnumber");
        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNum(phnumber);
        service.addUser(user);

        resp.sendRedirect("/jsp/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
