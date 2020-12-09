package example.pc.servlet.production;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import example.pc.entity.Production;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/back/refreshproductionservlet")
public class RefreshProductionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IProductionService service = new ProductionServiceImpl();
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        System.out.println(paramJson);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(paramJson);
            Production production = jsonObject.toJavaObject(Production.class);
            service.updateProduction(production);
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
