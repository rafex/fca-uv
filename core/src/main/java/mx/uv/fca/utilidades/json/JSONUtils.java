package mx.uv.fca.utilidades.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.io.IOException;

public class JSONUtils {

    private static final ObjectMapper INSTANCE = new ObjectMapper();

    public static ObjectMapper createObjectMapper() {
        INSTANCE.registerModule(new Jdk8Module());
        INSTANCE.configure(SerializationFeature.INDENT_OUTPUT, true);
        INSTANCE.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return INSTANCE;
    }

    public static JsonNode isValidJSON(final String json) {
        JsonNode jsonNode = null;
        try {
            jsonNode = INSTANCE.readTree(json);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return jsonNode;
    }

    public static Object json(final Object salida) {
        try {
            return INSTANCE.writerWithDefaultPrettyPrinter().writeValueAsString(salida);
        } catch (final JsonProcessingException e) {
            throw new UnsupportedOperationException("Error al convertir el objeto en JSON : " + e);
        }
    }

}
