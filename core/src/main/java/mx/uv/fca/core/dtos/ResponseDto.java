package mx.uv.fca.core.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.uv.fca.core.utilidades.json.JSONUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResponseDto implements Serializable {

	private static final long serialVersionUID = -4458983576716802026L;
	private static final ObjectMapper objectMapper = JSONUtils.getObjectMapper();

	private final String requestId;
	private final Integer code;
	private final byte[] body;
	private final Object returnValue;
	private final Map<String, List<String>> header;

	private ResponseDto(final ResponseBuilder responseBuilder) {
		this.code = responseBuilder.code;
		this.body = responseBuilder.body;
		this.header = responseBuilder.header;
		this.requestId = responseBuilder.requestId;
		this.returnValue = responseBuilder.returnValue;
	}

	public Boolean isOk() {
		return (this.code != null) && (this.code > 199) && (this.code < 300);
	}

	public String getRequestId() {
		return this.requestId;
	}

	public Integer getCode() {
		return this.code;
	}

	public byte[] getBody() {
		return this.body;
	}

	public Object getReturnValue() {
		return this.returnValue;
	}

	public <T> T getReturnValue(final Class<T> clazz) {
		T returnType = null;
		try {
			if ((this.body != null) && (clazz != null)) {
				returnType = objectMapper.readValue(new String(this.body, "UTF-8"), clazz);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return returnType;
	}

	public Map<String, List<String>> getHeader() {
		return this.header;
	}

	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\n\"Response\" : {");
		builder.append("\n\"code\" : ");
		builder.append("\"" + this.code + "\",");
		builder.append("\n\"body\" : ");
		try {
			builder.append("" + new String(this.body, "UTF-8") + ",");
		} catch (final Exception e) {
			builder.append("" + Arrays.toString(this.body) + ",");
		}
		builder.append("\n\"requestId\" : ");
		builder.append("\"" + this.requestId + "\"");
		builder.append("\n\"header\" : ");
		builder.append(this.header);
		builder.append("\n}");
		return builder.toString();
	}

	public static class ResponseBuilder {

		private String requestId;
		private final Integer code;
		private final byte[] body;
		private Object returnValue;
		private final Map<String, List<String>> header;

		public ResponseBuilder(final Integer code, final byte[] body, final Map<String, List<String>> header) {
			this.code = code;
			this.body = body;
			this.header = header;
		}

		public ResponseBuilder requestId(final String requestId) {
			this.requestId = requestId;
			return this;
		}

		public ResponseBuilder returnType(final Class<?> returnType) {
			try {
				if ((this.body != null) && (returnType != null)) {
					this.returnValue = objectMapper.readValue(new String(this.body, "UTF-8"), returnType);
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return this;
		}

		public ResponseDto build() {
			return (this.code != null) && (this.body != null) && (this.header != null) ? new ResponseDto(this) : null;
		}

	}

}
