package mx.uv.fca.business.mappers.catalogos;

import mx.uv.fca.daos.entidades.geos.EstadoEntidad;
import mx.uv.fca.dtos.Identificador;
import mx.uv.fca.dtos.geos.Estado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafex on 09/09/15.
 */
public class EstadoMapper {

    public static Estado mapTo(EstadoEntidad from) {
        Estado to = new Estado();

        Identificador id = new Identificador("estado", from.getId().toString());

        to.setId(id);
        to.setNombre(from.getNombre());
        to.setAbreviacion(from.getAbreviacion());

        return to;
    }

    public static List<Estado> mapTo(List<EstadoEntidad> fromList){
        List<Estado> toList = new ArrayList<Estado>();

        fromList.forEach(from -> {
            toList.add(mapTo(from));
        });

        return toList;
    }

}
