package mx.uv.fca.daos.mappers.geos;

import mx.uv.fca.daos.dtos.geos.Estados;
import mx.uv.fca.utilidades.identificadores.Identificador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafex on 08/09/15.
 */
public class GeoDaoMapper {

    public static List<Estados> mapEstados(final ResultSet resultSet) {

        final List<Estados> estados = new ArrayList<Estados>();

        try {
            while (resultSet.next()) {
                final Estados estado = mapEstado(resultSet);
                if (estado != null)
                    estados.add(estado);

            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return estados;
    }

    public static Estados mapEstado(final ResultSet resultSet) {
        Estados estado = null;
        try {
            final Integer id = resultSet.getInt("id");
            final String nombre = resultSet.getString("nombre");
            final String abreviacion = resultSet.getString("nombre");
            estado = new Estados();

            Identificador identificador = new Identificador("estado",id.toString());

            estado.setId(identificador);
            estado.setNombre(nombre);
            estado.setAbreviacion(abreviacion);

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return estado;
    }

}
