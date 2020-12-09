package example.pc.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import example.pc.service.IProductionService;
import example.pc.service.IUserService;
import example.pc.service.serviceImpl.ProductionServiceImpl;
import example.pc.service.serviceImpl.UserServiceImpl;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> map = new HashMap();
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        System.out.println(paramJson);

        map =  JSON.parseObject(paramJson,Map.class);


        String username = (String)map.get("account");
        String password = (String)map.get("password");
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("virtifyCode");
        String userCode = (String)map.get("code");
        if (code.equalsIgnoreCase(userCode)){
            if (userService.checkUser(username, password)) {
                session.setAttribute("account",username);
                session.setAttribute("password", password);
//                Cookie accountCookie = new Cookie("account", password);
//                Cookie passwordCookie = new Cookie("password", password);
//                passwordCookie.setMaxAge(60*60);
//                accountCookie.setMaxAge(60*60);
//                resp.addCookie(accountCookie);
//                resp.addCookie(passwordCookie);
                resp.getWriter().write("true");
            } else {
                resp.getWriter().write("false");
            }
        }else {
            resp.getWriter().write("false");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
