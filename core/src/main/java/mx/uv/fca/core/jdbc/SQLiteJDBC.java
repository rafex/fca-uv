package mx.uv.fca.core.jdbc;


import mx.uv.fca.core.enums.JDBCEnum;

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
