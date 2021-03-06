package mx.uv.fca.core.utilidades.sql;

import mx.uv.fca.core.enums.JDBCEnum;
import mx.uv.fca.core.jdbc.JDBCFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilidadSQL {

    private Connection conexion;
    private Statement declaracion;
    private ResultSet resultado;

    public UtilidadSQL(final JDBCEnum jdbcEnum, final String baseDeDatos) {
        this.conexion = JDBCFactory.getInstance(jdbcEnum, baseDeDatos).getConexion();
    }

    public ResultSet query(final String sql) throws SQLException {
        this.declaracion = this.conexion.createStatement();
        this.resultado = this.declaracion.executeQuery(sql);
        return this.resultado;
    }

    public ResultSet query(final String sql, final int v) throws SQLException {
        this.declaracion = this.conexion.createStatement();
        this.resultado = this.declaracion.executeQuery(sql);
        return this.resultado;
    }

    public int update(final String sql) throws SQLException {
        this.declaracion = this.conexion.createStatement();
        final int resultado = this.declaracion.executeUpdate(sql);
        return resultado;
    }

    public Connection getConexion() {
        return this.conexion;
    }

    public void cerrar() throws SQLException {
        if (this.declaracion != null)
            this.declaracion.close();

        if (this.conexion != null)
            this.conexion.close();

    }
}
