package example.pc.servlet.production;

import com.alibaba.fastjson.JSONObject;
import example.pc.service.IProductionService;
import example.pc.service.IProductionTypesService;
import example.pc.service.serviceImpl.ProductionServiceImpl;
import example.pc.service.serviceImpl.ProductionTypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getproductiontypes")
public class GetProductionTypesServlet extends HttpServlet {
    IProductionTypesService productionTypesService = new ProductionTypesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> allProductionTypes = productionTypesService.getAllProductionTypes();
        String s = JSONObject.toJSONString(allProductionTypes);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
