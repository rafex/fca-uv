package mx.uv.fca.web.utilidades.sesiones;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
public class SesionUtil {

	public Object getAttribute(final String attribute) {
		return getSession().getAttribute(attribute);
	}

	public <T> T getAttribute(final String attribute, final Class<?> to) {
		return (T) to.cast(getSession().getAttribute(attribute));
	}

	public void setAttribute(final String attribute, final Object value) {
		getSession().setAttribute(attribute, value);
	}

	public void removeAttribute(final String attribute) {
		getSession().removeAttribute(attribute);
	}

	private HttpSession getSession() {
		final ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return servletRequestAttributes.getRequest().getSession(false);
	}

	public void invalidate() {
		getSession().invalidate();
	}

}
