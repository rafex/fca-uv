package mx.uv.fca.test.utilidades.configuraciones;

import mx.uv.fca.test.utilidades.archivos.UtilidadArchivos;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilidadPropiedades {

    private static final Log LOG = LogFactory.getLog(UtilidadPropiedades.class);
    private static final String PATH_PROPIEDADES = "META-INF/variables.properties";

    private UtilidadPropiedades() {
    }

    public static String obtener(final String propiedad) {

        if (StringUtils.isBlank(propiedad))
            throw new NullPointerException();

        final Properties propiedades = obtenerTodas();
        final String valorPropiedad = StringUtils.defaultString(propiedades.getProperty(propiedad));

        return valorPropiedad;
    }

    public static Properties obtenerTodas() {

        final Properties propiedades = new Properties();

        final InputStream is = UtilidadArchivos.classLoader(PATH_PROPIEDADES);

        if (is != null) {
            try {
                propiedades.load(is);
            } catch (final IOException e) {
                errorObtenerPropiedades(e);
            }
        }


        return propiedades;
    }

    private static void errorObtenerPropiedades(IOException e) {
        LOG.error("Error al cargar propiedades", e);
        e.printStackTrace();
    }
}
