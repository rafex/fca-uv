package mx.uv.fca.utilidades.rest;

import mx.uv.fca.enums.MediaTypeEnum;
import mx.uv.fca.utilidades.Constantes;
import mx.uv.fca.utilidades.json.JSONUtils;
import mx.uv.fca.utilidades.xml.XMLUtils;
import spark.Request;
import spark.Response;

public class UtilidadRest {

    public static Boolean isApplicationJson(final Request request) {
        final String contentType = request.headers(Constantes.CONTENT_TYPE);
        return MediaTypeEnum.JSON.esIgual(contentType);
    }

    public static void setApplicationType(final Request request, final Response response) {
        try {
            final String contentType = request.headers(Constantes.CONTENT_TYPE);
            final MediaTypeEnum mediaType = MediaTypeEnum.JSON.parse(contentType);
            response.type(mediaType.getValor());
        } catch (final Exception e) {
            response.type(MediaTypeEnum.JSON.getValor());
        }

    }

    public static Object generarSalida(final Request request, final Object salida) {

        if (salida instanceof String)
            return JSONUtils.json(salida);
        else if (!isApplicationJson(request))
            return JSONUtils.json(salida);
        else
           return XMLUtils.xml(salida);

    }


}
