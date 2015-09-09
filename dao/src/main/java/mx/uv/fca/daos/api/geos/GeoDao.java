package mx.uv.fca.daos.api.geos;

import mx.uv.fca.daos.dtos.geos.Estados;
import mx.uv.fca.daos.mappers.geos.GeoDaoMapper;
import mx.uv.fca.enums.JDBCEnum;
import mx.uv.fca.test.utilidades.sql.UtilidadSQL;

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

        final ListadoEstadosDaoOutDto listadoPaisesDaoOutDto = new ListadoEstadosDaoOutDto(new ArrayList<Estados>());

        try {
            final ResultSet resultSet = utilSql.query("SELECT * FROM estados");
            listadoPaisesDaoOutDto.setEstados(GeoDaoMapper.mapEstados(resultSet));

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return listadoPaisesDaoOutDto;
    }



}
