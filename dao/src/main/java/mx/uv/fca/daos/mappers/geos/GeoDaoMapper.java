package mx.uv.fca.daos.mappers.geos;

import mx.uv.fca.daos.entidades.geos.EstadoEntidad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafex on 08/09/15.
 */
public class GeoDaoMapper {

    public static List<EstadoEntidad> mapTo(final ResultSet from) {

        final List<EstadoEntidad> to = new ArrayList<EstadoEntidad>();

        try {
            while (from.next()) {
                final EstadoEntidad estado = mapEstado(from);
                if (estado != null)
                    to.add(estado);

            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return to;
    }

    public static EstadoEntidad mapEstado(final ResultSet from) {
        EstadoEntidad estado = null;
        try {
            final Integer id = from.getInt("id");
            final String nombre = from.getString("nombre");
            final String abreviacion = from.getString("nombre");
            estado = new EstadoEntidad();


            estado.setId(id);
            estado.setNombre(nombre);
            estado.setAbreviacion(abreviacion);

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

}
