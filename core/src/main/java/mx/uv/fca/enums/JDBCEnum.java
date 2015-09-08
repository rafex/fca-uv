package mx.uv.fca.enums;

import org.apache.commons.lang3.StringUtils;

public enum JDBCEnum {

    SQLITE("org.sqlite.JDBC"), MARIADB("org.mariadb.jdbc.Driver");

    private String valor;

    private JDBCEnum(final String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public JDBCEnum parse(final String valorEntrada) {

        if (StringUtils.isBlank(valorEntrada)) {
            throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + JDBCEnum.class.getName());
        }

        for (final JDBCEnum tipoEnum : values()) {
            if (tipoEnum.valor.equalsIgnoreCase(valorEntrada)) {
                return tipoEnum;
            }
        }

        throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + JDBCEnum.class.getName());
    }

}
