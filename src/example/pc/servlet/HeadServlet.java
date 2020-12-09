package example.pc.servlet;

import com.alibaba.fastjson.JSON;
import example.pc.entity.CompanyAdvance;
import example.pc.service.ICompanyAdviceService;
import example.pc.service.IEquitmentService;
import example.pc.service.serviceImpl.CompanyAdviceServiceImpl;
import example.pc.service.serviceImpl.EquitmentServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/head")
public class HeadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = new HashMap();
        ICompanyAdviceService companyAdviceService = new CompanyAdviceServiceImpl();
        IEquitmentService equitmentService = new EquitmentServiceImpl();
        map.put("advance", companyAdviceService.getAdvances());
        map.put("equipment", equitmentService.getEquipments());
        for (CompanyAdvance x: companyAdviceService.getAdvances()){
            System.out.println(x.toString());
        }
        String s = JSON.toJSONString(map);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(s);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
