package example.pc.servlet.production;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Nav;
import example.pc.entity.Page;
import example.pc.service.INavService;
import example.pc.service.IProductionService;
import example.pc.service.IProductionTypesService;
import example.pc.service.serviceImpl.NavServiceImpl;
import example.pc.service.serviceImpl.ProductionServiceImpl;
import example.pc.service.serviceImpl.ProductionTypesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/product")
public class ProductionServlet extends HttpServlet {
    IProductionService productionService = new ProductionServiceImpl();
    INavService navService = new NavServiceImpl();
    IProductionTypesService productionTypesService = new ProductionTypesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        Page page = new Page();
        page.setMaxsize(8);
        page.setCurrentPage(1);
        //分页查询产品
        if (req.getParameter("currentPage")!=null){
            page.setCurrentPage(Integer.valueOf(req.getParameter("currentPage")));
        }


        map.put("productions", productionService.getProductionByPage(page));
        Nav nav = navService.getSingleNav("产品中心");
        map.put("pagename", nav.getTitle());
        map.put("pageusname", nav.getUsPagename());
//        req.getRequestDispatcher("/jsp/productionCenter.jsp").forward(req,resp);
        String s = JSON.toJSONString(map);
        resp.getWriter().write(s);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
