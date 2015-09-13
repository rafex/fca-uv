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
@WebFilter("/privado/*")
public class AreaPrivadaFiltro implements Filter {

    private static final String KEY_HEADER = "key";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            String contextPath = httpServletRequest.getContextPath();

            String key = httpServletRequest.getParameter(KEY_HEADER);

            final HttpSession session = httpServletRequest.getSession(false);

            if (!(session != null && StringUtils.isNotBlank(key) && ((String) session.getAttribute(KEY_HEADER)).equals(key))) {
                sinAcceso(response, contextPath);
            }

            filter.doFilter(request, response);
        }

    }

    private void sinAcceso(ServletResponse response, String contextPath) {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            try {
                httpServletResponse.sendRedirect(contextPath + "/401.jsp");
            } catch (IOException e) {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
