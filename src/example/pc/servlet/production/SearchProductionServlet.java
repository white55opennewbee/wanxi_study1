package example.pc.servlet.production;

import com.alibaba.fastjson.JSONObject;
import example.pc.dto.ProductionSearchInfo;
import example.pc.entity.Page;
import example.pc.entity.Production;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/back/searchproduction")
public class SearchProductionServlet extends HttpServlet {
    IProductionService service = new ProductionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap map = new HashMap();

        String selection = req.getParameter("selection");
        String lowestPrice = req.getParameter("lowestPrice");
        String searchByName = req.getParameter("searchByName");
        String maxPrice = req.getParameter("maxPrice");
        String maxSize = req.getParameter("maxSize");
        String currentPage = req.getParameter("currentPage");

        Page page = new Page();
        page.setCurrentPage(Integer.valueOf(currentPage));
        page.setMaxsize(Integer.valueOf(maxSize));


        ProductionSearchInfo productionSearchInfo = new ProductionSearchInfo();
        productionSearchInfo.setLowestPrice(lowestPrice);
        productionSearchInfo.setMaxPrice(maxPrice);
        productionSearchInfo.setSearchByName(searchByName);
        productionSearchInfo.setSelection(selection);
        System.out.println(productionSearchInfo);
        System.out.println(page);

        List<Production> productions = service.findProductionBySearch(productionSearchInfo,page);


        int counts = service.getPagesBySearch(productionSearchInfo);
        map.put("counts",counts);
        map.put("productions",productions);
        String s = JSONObject.toJSONString(map);
        resp.setContentType("application/json;charset = utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
