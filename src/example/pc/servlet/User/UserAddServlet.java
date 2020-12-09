package example.pc.servlet.User;

import com.alibaba.fastjson.JSONObject;
import example.pc.entity.User;
import example.pc.service.IUserService;
import example.pc.service.serviceImpl.UserServiceImpl;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/useradd")
public class UserAddServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = IOUtils.toString(req.getInputStream(), "UTF-8");
        User user = JSONObject.parseObject(data,User.class);
        System.out.println(data);
        System.out.println(user);
        try {
            service.addUser(user);
            resp.getWriter().write("true");
        }catch (Exception e){
            resp.getWriter().write("false");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
