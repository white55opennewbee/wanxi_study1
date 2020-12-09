package example.pc.servlet;

import example.pc.thread.CodeCreater;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/img")
public class CodeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CodeCreater codeCreater = new CodeCreater();
        String code = codeCreater.getCode();
        HttpSession session = req.getSession();

        session.setAttribute("virtifyCode",code);
        BufferedImage image = codeCreater.changeToBufferedImage(code);
        resp.setContentType("image/jpeg");
        ImageIO.write(image,"jpeg",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
