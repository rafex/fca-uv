package mx.uv.fca.daos.api.geos;

import mx.uv.fca.daos.dtos.geos.ListadoEstadosDaoOutDto;
import mx.uv.fca.daos.entidades.geos.EstadoEntidad;
import mx.uv.fca.daos.mappers.geos.GeoDaoMapper;
import mx.uv.fca.core.enums.JDBCEnum;
import mx.uv.fca.core.utilidades.sql.UtilidadSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rafex on 08/09/15.
 */
public class GeoDao {

    private static UtilidadSQL utilSql;
    private static final String BD = "fca_uv";

    public static ListadoEstadosDaoOutDto getListadoEstados() {

        utilSql = new UtilidadSQL(JDBCEnum.MARIADB, BD);

        final ListadoEstadosDaoOutDto listadoPaisesDaoOutDto = new ListadoEstadosDaoOutDto(new ArrayList<EstadoEntidad>());

        try {
            final ResultSet resultSet = utilSql.query("SELECT * FROM estados");
            listadoPaisesDaoOutDto.setEstados(GeoDaoMapper.mapTo(resultSet));

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if(utilSql != null)
                    utilSql.cerrar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listadoPaisesDaoOutDto;
    }



}
