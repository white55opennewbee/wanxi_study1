package example.pc.thread;

import com.alibaba.fastjson.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/back/uploadImg")
public class UploadImgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storePath = getServletContext().getRealPath("/img");
        String imgName = "";
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
        try {
            List<FileItem> items = upload.parseRequest(req);
            for (FileItem item:items){
                if (!item.isFormField()){
                    InputStream in = item.getInputStream();
                    String name = item.getName();
                    String fileName = name.substring(name.lastIndexOf("/")+1);
                    String storeFile = storePath+"/"+fileName;
                    imgName = fileName;
                    OutputStream outputStream = new FileOutputStream(storeFile);
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = in.read(b))!=-1){
                        outputStream.write(b,0,len);
                    }
                    in.close();
                    outputStream.close();
                    resp.setContentType("application/json;charset=utf-8");
                    Map map = new HashMap();
                    map.put("imgname",imgName);
                    map.put("type","success");
                    String result = JSON.toJSONString(map);
                    System.out.println(result);
                    resp.getWriter().write(result);
                }else {
                    resp.getWriter().write("error");
                }
            }



        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
