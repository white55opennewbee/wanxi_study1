package example.pc.servlet.production;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Production;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/getsingleproduction")
public class GetSingleProductionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProductionService service = new ProductionServiceImpl();
        String id = req.getParameter("id");
        Production singleProduction = service.getSingleProduction(id);
        String s = JSON.toJSONString(singleProduction);
        System.out.println(s);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
