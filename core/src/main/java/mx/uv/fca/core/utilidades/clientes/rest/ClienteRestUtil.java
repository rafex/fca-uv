package mx.uv.fca.core.utilidades.clientes.rest;

import mx.uv.fca.core.dtos.AuthenticationProxyDto;
import mx.uv.fca.core.dtos.ProxyDto;
import mx.uv.fca.core.dtos.ResponseDto;
import mx.uv.fca.core.utilidades.configuraciones.UtilidadPropiedades;
import mx.uv.fca.core.utilidades.uuid.UuidGeneratorGeneric;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ClienteRestUtil {

    private final static Boolean proxyActive = UtilidadPropiedades.obtenerBooleano("VAR.PROXY.ACTIVE");
    private final static String proxyPassword = UtilidadPropiedades.obtener("VAR.PROXY.PASSWORD");
    private final static String proxyUser = UtilidadPropiedades.obtener("VAR.PROXY.USER");
    private final static String proxyHost = UtilidadPropiedades.obtener("VAR.PROXY.HOST");
    private final static Integer proxyPort = UtilidadPropiedades.obtenerEntero("VAR.PROXY.PORT");

    private final static Boolean cacheActive = UtilidadPropiedades.obtenerBooleano("VAR.CACHE.ACTIVE");
    private final static Integer timeOut = UtilidadPropiedades.obtenerEntero("VAR.TIME.OUT");
    private final static Integer timeRead = UtilidadPropiedades.obtenerEntero("VAR.TIME.READ");

    private static ResponseDto client(final String host, final String request, final String method, final Map<String, Object> headers, final Class<?> returnType) {

        System.out.println("");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("Method: " + method);
        System.out.println("Host: " + host);
        System.out.println("Headers: " + headers);
        System.out.println("Request: " + request);
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("");

        final String requestId = UuidGeneratorGeneric.generateUuid();
        HttpURLConnection conn = null;
        OutputStream os = null;
        try {
            String url = host;

            if (HttpMethod.GET.equalsIgnoreCase(method)) {
                String requestTmp = request.trim().substring(1);
                requestTmp = requestTmp.substring(0, requestTmp.length() - 1);
                url = host + requestTmp;
            }

            final URL path = new URL(url);

            if (proxyActive) {
                conn = (HttpURLConnection) path.openConnection(proxy());
            } else {
                conn = (HttpURLConnection) path.openConnection();
            }

            conn.setRequestMethod(method);

            conn.setUseCaches(cacheActive);
            conn.setConnectTimeout(timeOut);
            conn.setReadTimeout(timeRead);

            conn.setRequestProperty("RequestId", requestId);

            for (final Entry<String, Object> entry : headers.entrySet()) {
                if ((entry.getKey() != null) && (entry.getValue() != null)) {
                    conn.setRequestProperty(entry.getKey(), entry.getValue().toString());
                }
            }

            if (HttpMethod.POST.equalsIgnoreCase(method) || HttpMethod.PUT.equalsIgnoreCase(method)) {
                conn.setDoOutput(true);
                os = conn.getOutputStream();
                os.write(request.getBytes());
                os.flush();
            }

            final int code = conn.getResponseCode();
            byte[] body = null;
            final Map<String, List<String>> headersResponse = conn.getHeaderFields();
            if ((code > 199) && (code < 300)) {
                body = IOUtils.toByteArray(conn.getInputStream());
                // throw new UnsupportedOperationException("Failed : HTTP error
                // code
                // : " + conn.getResponseCode() + "\n " + result);
            } else {
                body = IOUtils.toByteArray(conn.getErrorStream());
            }

            return new ResponseDto.ResponseBuilder(code, body, headersResponse).requestId(requestId).returnType(returnType).build();

        } catch (final Exception e) {
            throw new UnsupportedOperationException(e);
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static ResponseDto get(final String url, final String request, final Map<String, Object> headers, final Class<?> returnType) {
        return client(url, request, HttpMethod.GET, defaulHeaders(headers), returnType);
    }

    public static ResponseDto get(final String url, final String request, final Map<String, Object> headers) {
        return get(url, request, headers, null);
    }

    public static ResponseDto get(final String url, final String request) {
        return get(url, request, null, null);
    }

    public static ResponseDto post(final String url, final String request, final Map<String, Object> headers, final Class<?> returnType) {
        return client(url, request, HttpMethod.POST, defaulHeaders(headers), returnType);
    }

    public static ResponseDto post(final String url, final String request, final Map<String, Object> headers) {
        return post(url, request, headers, null);
    }

    public static ResponseDto post(final String url, final String request) {
        return post(url, request, null, null);
    }

    public static ResponseDto post(final String url, final String request, final Class<?> returnType) {
        return post(url, request, null, returnType);
    }

    private static Map<String, Object> defaulHeaders(final Map<String, Object> headers) {
        final Map<String, Object> headerDefault = new HashMap<String, Object>();
        headerDefault.put("Accept", MediaType.WILDCARD);
        headerDefault.put("Content-Type", MediaType.APPLICATION_JSON);

        if (headers != null) {
            headers.forEach((key, value) -> headerDefault.put(key, value));
        }
        return headerDefault;
    }

    private static Proxy proxy() {

        final ProxyDto proxy = new ProxyDto.ProxyBuilder(proxyHost, proxyPort).authentication(new AuthenticationProxyDto
                .AuthenticationProxyBuilder(proxyUser).password(proxyPassword).build()).build();
        if (proxy.getAuthentication() != null) {

            final Authenticator authenticator = new Authenticator() {

                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(proxy.getAuthentication().getUser(), proxy.getAuthentication().getPassword().toCharArray());
                }
            };
            Authenticator.setDefault(authenticator);
        }
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy.getHost(), proxy.getPort()));
    }
}
