package example.pc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "logFilter",
        urlPatterns = {"/ignore/back/*", "/ignore/html/backManager/*"}
)
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("loginFil");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String requestURI = req.getServletPath();
        int n = requestURI.lastIndexOf("/");
        String name = requestURI.substring(n + 1);
        if (!("login.html").equals(name)) {
            if (searchUserInCookie(req)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                System.out.println("重定向");
                resp.sendRedirect("/html/backManager/login.html");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }

    public Boolean searchUserInCookie(HttpServletRequest req) {

//        String account = "";
//        String password = "";
//        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
//        if (cookies != null && cookies.length > 0) {
            if (session.getAttribute("account")!=null&&session.getAttribute("account").toString().trim()!=""){
                if (session.getAttribute("password")!=null&&session.getAttribute("password").toString().trim()!=""){
                    return true;
                }
            }
            return false;
//            for (Cookie c : cookies) {
//                if (c.getName().equals("account")) {
//                    account = c.getValue().trim();
//                    if (password != "") {
//                        break;
//                    }
//                }
//                if (c.getName().equals("password")) {
//                    password = c.getValue().trim();
//                    if (account != "") {
//                        break;
//                    }
//                }
//            }
//        }
//        if (account == "" || password == "") {
//            return false;
//        } else {
//            return true;
//        }


    }


}
