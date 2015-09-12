package mx.uv.fca.web.filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rafex on 11/09/15.
 */
@WebFilter("/*")
public class CabezeraFiltro implements Filter {

    private static final String AUTHENTICATION_HEADER = "Authorization";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filter) throws IOException,
            ServletException {

        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;

            if (response instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                /*httpServletResponse.setHeader("Access-Control-Allow-Origin","http://localhost:8888");
                httpServletResponse.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, DELETE, OPTIONS");
                httpServletResponse.setHeader("Access-Control-Allow-Headers","X-Requested-With");*/
            }
            filter.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
