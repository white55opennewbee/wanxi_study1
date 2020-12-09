package example.pc.servlet.production;

import com.alibaba.fastjson.JSON;
import example.pc.entity.Production;
import example.pc.service.IProductionService;
import example.pc.service.serviceImpl.ProductionServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.print.attribute.standard.NumberUp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/back/addproduction")
public class AddProductionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IProductionService productionService = new ProductionServiceImpl();
        String paramJson = IOUtils.toString(req.getInputStream(), "UTF-8");
        System.out.println(paramJson);
        Production production = JSON.parseObject(paramJson).toJavaObject(Production.class);
        System.out.println(production.getStatus());
        productionService.addProduction(production);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
