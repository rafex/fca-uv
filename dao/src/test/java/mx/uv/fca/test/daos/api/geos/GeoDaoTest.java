package mx.uv.fca.test.daos.api.geos;

import mx.uv.fca.daos.api.geos.GeoDao;
import mx.uv.fca.daos.api.geos.ListadoEstadosDaoOutDto;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rafex on 08/09/15.
 */
public class GeoDaoTest {

    @Test
    public void listadoEstados(){

        ListadoEstadosDaoOutDto listadoEstados = GeoDao.getListadoEstados();

        Assert.assertNotNull(listadoEstados);
        Assert.assertNotNull(listadoEstados.getEstados());
        Assert.assertTrue(!listadoEstados.getEstados().isEmpty());

    }
}
