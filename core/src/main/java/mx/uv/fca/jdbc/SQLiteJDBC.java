package mx.uv.fca.jdbc;


import mx.uv.fca.enums.JDBCEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteJDBC implements IJDBC {

    private Connection conexion;

    static {
    }

    SQLiteJDBC() {
        try {
            Class.forName(JDBCEnum.SQLITE.getValor());
            this.conexion = DriverManager.getConnection("jdbc:sqlite::resource:META-INF/db/core.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConexion() {
        return this.conexion;
    }

}
