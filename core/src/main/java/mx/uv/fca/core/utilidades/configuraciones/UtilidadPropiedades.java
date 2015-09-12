package mx.uv.fca.core.utilidades.configuraciones;

import mx.uv.fca.core.utilidades.archivos.UtilidadArchivos;
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

        final Properties propiedades = obtenerPropiedades();
        final String valorPropiedad = StringUtils.defaultString(propiedades.getProperty(propiedad), null);

        return valorPropiedad;
    }

    public static Boolean obtenerBooleano(String propiedad) {
        String propiedadEncotrada = obtener(propiedad);
        Boolean propiedadBoolean = null;
        if (propiedadEncotrada != null && (propiedadEncotrada.equalsIgnoreCase("FALSE") || propiedadEncotrada.equalsIgnoreCase("TRUE"))) {
            propiedadBoolean = Boolean.valueOf(propiedadEncotrada);
        }
        return propiedadBoolean;
    }

    public static Integer obtenerEntero(String propiedad) {
        String propiedadEncotrada = obtener(propiedad);
        Integer propiedadEntero = null;
        if(propiedadEncotrada != null) {
            try {
                propiedadEntero = Integer.parseInt(propiedadEncotrada.replace(" ", "").trim());
                return propiedadEntero;
            } catch (final Exception e) {
                // e.printStackTrace();
            }

        }
        return propiedadEntero;
    }

    public static Properties obtenerPropiedades() {

        final Properties propiedades = obtenerPropiedades(PATH_PROPIEDADES);

        return propiedades;
    }

    public static Properties obtenerPropiedades(String ruta) {
        final Properties propiedades = new Properties();

        final InputStream is = UtilidadArchivos.classLoader(ruta);

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
