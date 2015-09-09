package mx.uv.fca.api.catalogos;

import mx.uv.fca.daos.api.geos.GeoDao;
import mx.uv.fca.daos.api.geos.ListadoEstadosDaoOutDto;

/**
 * Created by rafex on 09/09/15.
 */
public class Generales {

    public static void estados(){
        final ListadoEstadosDaoOutDto listadoEstados = GeoDao.getListadoEstados();
    }

}
