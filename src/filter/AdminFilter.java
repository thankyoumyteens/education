package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Admin on 2017/8/30.
 */
@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"),request.getRequestURI().length());
        String ex = requestURI.substring(requestURI.lastIndexOf("."));
        if (".jsp".equals(ex) || "".equals(ex)) {
            if ("/login.jsp".equals(requestURI)) {
                chain.doFilter(request, response);
            } else {
                HttpSession session = request.getSession();
                if (session == null) {
                    response.sendRedirect("login.jsp");
                } else {
                    Object adminUser = session.getAttribute("admin");
                    if (adminUser == null) {
                        response.sendRedirect("login.jsp");
                    } else {
                        chain.doFilter(request, response);
                    }
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
