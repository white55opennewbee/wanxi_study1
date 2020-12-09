package example.pc.servlet.news;

import com.alibaba.fastjson.JSON;
import example.pc.service.INewsTypesService;
import example.pc.service.serviceImpl.NewsTypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/back/getnewstypes")
public class GetNewsTypesServlet extends HttpServlet {
    INewsTypesService service = new NewsTypesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> newsAllTypes = service.getNewsAllTypes();
        resp.setContentType("application/json;charset=utf-8");
        String s = JSON.toJSONString(newsAllTypes);
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
