package mx.uv.fca.core.dtos;

public class AuthenticationProxyDto {

	private final String user;
	private final String password;

	private AuthenticationProxyDto(final AuthenticationProxyBuilder authenticationProxyBuilder) {
		this.user = authenticationProxyBuilder.user;
		this.password = authenticationProxyBuilder.password;
	}

	public String getUser() {
		return this.user;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("AuthenticationProxyDto [user=");
		builder.append(this.user);
		builder.append(", password=");
		builder.append(this.password);
		builder.append("]");
		return builder.toString();
	}

	public static class AuthenticationProxyBuilder {
		private final String user;
		private String password;

		public AuthenticationProxyBuilder(final String user) {
			this.user = user;
		}

		public AuthenticationProxyBuilder password(final String password) {
			this.password = password;
			return this;
		}

		public AuthenticationProxyDto build() {
			return this.user != null ? new AuthenticationProxyDto(this) : null;
		}

	}

}
