package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        req.setCharacterEncoding("utf-8");

        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getRequestURL().toString();
        String urls[]=new String[]{
                "/loginServlet","/index.jsp","/regist.jsp","/img/","/regist"
        };
        for(String u:urls){
            if(url.contains(u)){
                chain.doFilter(req,resp);
                resp.setCharacterEncoding("utf-8");
                return;
            }
        }
        HttpSession session=request.getSession();
        Object student = session.getAttribute("student");
        if(student!=null){
            chain.doFilter(req,resp);
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request,resp);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
