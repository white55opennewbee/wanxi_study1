package example.pc.servlet.production;

import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/back/deleteproduction")
public class DeleteProduction extends HttpServlet {
    IProductionService productionService = new ProductionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productionService.deleteProduction(Integer.valueOf(req.getParameter("id")));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
