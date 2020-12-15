package example.pc.servlet.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import example.pc.entity.User;
import example.pc.service.IUserService;
import example.pc.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findall")
public class FindAllUserServlet extends HttpServlet {
    IUserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all = service.findAll();
        String jsonObject = JSON.toJSONString(all);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonObject);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
