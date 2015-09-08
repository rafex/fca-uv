package mx.uv.fca.jdbc;


import mx.uv.fca.enums.JDBCEnum;

import java.util.HashMap;

public class JDBCFactory {

    private static final HashMap<JDBCEnum, IJDBC> jdbcMap = new HashMap<JDBCEnum, IJDBC>();

    private JDBCFactory() {
    }

    public static IJDBC getInstance(final JDBCEnum tipo, final String baseDeDatos) {
        switch (tipo) {
            case SQLITE:
                final SQLiteJDBC sqlite_jdbc = (SQLiteJDBC) jdbcMap.get(tipo);
                return sqlite_jdbc == null ? new SQLiteJDBC() : sqlite_jdbc;
            case MARIADB:
                MariaDBJDBC mariadb_jdbc = (MariaDBJDBC) jdbcMap.get(tipo);

                if (mariadb_jdbc == null) {
                    mariadb_jdbc = new MariaDBJDBC();
                    jdbcMap.put(tipo, mariadb_jdbc);
                }

                mariadb_jdbc.setBaseDeDatos(baseDeDatos);
                return mariadb_jdbc;
            default:
                return null;
        }
    }

}
