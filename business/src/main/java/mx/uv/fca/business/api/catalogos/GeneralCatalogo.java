package mx.uv.fca.business.api.catalogos;

import mx.uv.fca.business.dtos.catalogos.ListadoEstadosBusinessOutDto;
import mx.uv.fca.business.mappers.catalogos.EstadoMapper;
import mx.uv.fca.daos.api.geos.GeoDao;
import mx.uv.fca.daos.dtos.geos.ListadoEstadosDaoOutDto;

/**
 * Created by rafex on 09/09/15.
 */
public class GeneralCatalogo {

    public static ListadoEstadosBusinessOutDto estados(){
        final ListadoEstadosDaoOutDto listadoEstados = GeoDao.getListadoEstados();
        return new ListadoEstadosBusinessOutDto(EstadoMapper.mapTo(listadoEstados.getEstados()));
    }

}
