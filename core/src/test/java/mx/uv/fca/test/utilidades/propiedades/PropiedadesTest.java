package mx.uv.fca.test.utilidades.propiedades;

import mx.uv.fca.test.utilidades.configuraciones.UtilidadPropiedades;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class PropiedadesTest {

    @Test
    public void obtenerPropiedad() {

        final String version = UtilidadPropiedades.obtener("VAR.VERSION");

        Assert.assertTrue(StringUtils.isNotBlank(version));

    }

    @Test
    public void obtenerTodasLasPropiedad() {

        final Properties obtenerTodas = UtilidadPropiedades.obtenerTodas();

        Assert.assertNotNull(obtenerTodas);
        Assert.assertFalse(obtenerTodas.isEmpty());

    }

    @Test
    public void contieneLaPalabraVAR() {
        final String propiedadConVAR = "VAR.VERSION";
        final String propiedadSinVAR = "VERSION";

        Assert.assertTrue(propiedadConVAR.contains("VAR"));
        Assert.assertFalse(propiedadSinVAR.contains("VAR"));
    }

}
