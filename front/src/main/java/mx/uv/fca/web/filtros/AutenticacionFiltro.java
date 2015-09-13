package mx.uv.fca.web.filtros;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by rafex on 11/09/15.
 */
@WebFilter("/login.jsp")
public class AutenticacionFiltro implements Filter {

    private static final String KEY_HEADER = "key";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filter) throws IOException,
            ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String contextPath = httpServletRequest.getContextPath();

            final HttpSession session = httpServletRequest.getSession(false);

            if (session != null && StringUtils.isNotBlank((String) session.getAttribute(KEY_HEADER)) && response instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect(contextPath + "/privado/panel.jsp?key=" + (String) session.getAttribute(KEY_HEADER));
            }

            filter.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
