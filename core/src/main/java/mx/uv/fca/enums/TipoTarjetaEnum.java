package mx.uv.fca.enums;

import org.apache.commons.lang3.StringUtils;

public enum TipoTarjetaEnum {

    CREDITO("TDC"), DEBITO("TDB");

    private String valor;

    private TipoTarjetaEnum(final String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public TipoTarjetaEnum parse(final String valorEntrada) {

        if (StringUtils.isBlank(valorEntrada)) {
            throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + TipoTarjetaEnum.class.getName());
        }

        for (final TipoTarjetaEnum tipoEnum : values()) {
            if (tipoEnum.valor.equalsIgnoreCase(valorEntrada)) {
                return tipoEnum;
            }
        }

        throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + TipoTarjetaEnum.class.getName());
    }

}
