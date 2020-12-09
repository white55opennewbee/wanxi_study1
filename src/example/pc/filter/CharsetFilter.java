package example.pc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
@WebFilter(
        filterName = "CharsetFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "charset",value = "utf-8")
        }
)
public class CharsetFilter implements Filter {
    private String charset;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset = filterConfig.getInitParameter("charset");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charset);
        servletResponse.setCharacterEncoding(charset);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
