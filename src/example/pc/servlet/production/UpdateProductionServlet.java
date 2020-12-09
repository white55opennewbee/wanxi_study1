package example.pc.servlet.production;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import example.pc.entity.Page;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/updateproduction")
public class UpdateProductionServlet extends HttpServlet {
    IProductionService productionService = new ProductionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Page p = new Page();
        p.setMaxsize(8);
        p.setCurrentPage(1);
        //分页查询产品
        if (req.getParameter("currentPage")!=null){
            p.setCurrentPage(Integer.valueOf(req.getParameter("currentPage")));
        }
        String productions = JSON.toJSONString(productionService.getProductionByPage(p));
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(productions);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
