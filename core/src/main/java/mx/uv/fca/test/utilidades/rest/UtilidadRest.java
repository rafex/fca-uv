package mx.uv.fca.test.utilidades.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.uv.fca.enums.MediaTypeEnum;
import mx.uv.fca.test.utilidades.Constantes;
import mx.uv.fca.test.utilidades.json.JSONUtils;
import spark.Request;
import spark.Response;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class UtilidadRest {

    private static final ObjectMapper mapper = JSONUtils.createObjectMapper();

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
            return crearMensajeEnJSON(salida);
        else if (!isApplicationJson(request))
            return crearMensajeEnJSON(salida);
        else
            try {
                final JAXBContext jaxbContext = JAXBContext.newInstance(salida.getClass());
                final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                final StringWriter sw = new StringWriter();
                jaxbMarshaller.marshal(salida, sw);
                return sw;
            } catch (final JAXBException e) {
                throw new UnsupportedOperationException("Error al convertir el objeto en XML : " + e);
            }

    }

    private static Object crearMensajeEnJSON(final Object salida) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(salida);
        } catch (final JsonProcessingException e) {
            throw new UnsupportedOperationException("Error al convertir el objeto en JSON : " + e);
        }
    }

}
