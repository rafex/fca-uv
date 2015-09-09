package mx.uv.fca.jdbc;


import mx.uv.fca.enums.JDBCEnum;
import mx.uv.fca.test.utilidades.configuraciones.UtilidadPropiedades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MariaDBJDBC implements IJDBC {

    private String baseDeDatos;
    private Connection conexion;

    static {
    }

    MariaDBJDBC() {
    }

    MariaDBJDBC(final String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(final String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public void setConexion(final Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Connection getConexion() {
        conectar();
        return conexion;
    }

    private void conectar() {
        try {
            Class.forName(JDBCEnum.MARIADB.getValor());

            final String url = "jdbc:mariadb://" + UtilidadPropiedades.obtener("VAR.MARIADB.IP") + ":" + UtilidadPropiedades.obtener("VAR.MARIADB.PORT") + "/" + baseDeDatos;

            conexion = DriverManager.getConnection(url, UtilidadPropiedades.obtener("VAR.MARIADB.USER"), UtilidadPropiedades.obtener("VAR.MARIADB.PASSWORD"));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
