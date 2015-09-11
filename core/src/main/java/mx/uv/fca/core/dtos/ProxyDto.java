package mx.uv.fca.core.dtos;

public class ProxyDto {

	private final String host;
	private final String port;
	private final AuthenticationProxyDto authentication;

	private ProxyDto(final ProxyBuilder proxybuilder) {
		this.host = proxybuilder.host;
		this.port = proxybuilder.port;
		this.authentication = proxybuilder.authentication;
	}

	public String getHost() {
		return this.host;
	}

	public Integer getPortInt() {
		return Integer.parseInt(this.port);
	}

	public String getPort() {
		return this.port;
	}

	public AuthenticationProxyDto getAuthentication() {
		return this.authentication;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("ProxyDto [host=");
		builder.append(this.host);
		builder.append(", port=");
		builder.append(this.port);
		builder.append(", authentication=");
		builder.append(this.authentication);
		builder.append("]");
		return builder.toString();
	}

	public static class ProxyBuilder {
		private final String host;
		private final String port;
		private AuthenticationProxyDto authentication;

		public ProxyBuilder(final String host, final String port) {
			this.port = port;
			this.host = host;
		}

		public ProxyBuilder authentication(final AuthenticationProxyDto authentication) {
			this.authentication = authentication;
			return this;
		}

		public ProxyDto build() {
			return (this.host != null) && (this.port != null) ? new ProxyDto(this) : null;
		}
	}

}
