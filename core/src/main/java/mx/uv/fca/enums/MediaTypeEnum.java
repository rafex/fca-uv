package mx.uv.fca.enums;

import mx.uv.fca.test.utilidades.Constantes;
import org.apache.commons.lang3.StringUtils;

public enum MediaTypeEnum {

    JSON(Constantes.APPLICATION_JSON), XML(Constantes.APPLICATION_XML);

    private String valor;

    private MediaTypeEnum(final String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public MediaTypeEnum parse(final String valorEntrada) {

        if (StringUtils.isBlank(valorEntrada)) {
            throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + MediaTypeEnum.class.getName());
        }

        for (final MediaTypeEnum tipoEnum : values()) {
            if (tipoEnum.valor.equalsIgnoreCase(valorEntrada)) {
                return tipoEnum;
            }
        }

        throw new UnsupportedOperationException("No se puedo convertir el valor al tipo enum: " + MediaTypeEnum.class.getName());
    }

    public Boolean esIgual(final String valorEntrada) {

        Boolean esIgual = Boolean.FALSE;

        if (StringUtils.isNotBlank(valorEntrada) && valor.equalsIgnoreCase(valorEntrada)) {
            esIgual = Boolean.TRUE;
        }

        return esIgual;
    }

}
