package mx.uv.fca.core.utilidades.codificacion;

import mx.uv.fca.core.enums.CodificadorEnum;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

public class Base64 implements ICodificadorGenerico {

    Base64() {
    }

    byte[] decodificar(final String src) {

        if (StringUtils.isBlank(src)) {
            throw new NullPointerException();
        }

        final byte[] decode = decodificar(src.getBytes(StandardCharsets.UTF_8));

        return decode;
    }

    @Override
    public byte[] decodificar(final byte[] src) {

        if (src == null) {
            throw new NullPointerException();
        }

        final byte[] decode = java.util.Base64.getDecoder().decode(src);

        return decode;
    }

    String codificarACadena(final String src) {

        if (StringUtils.isBlank(src)) {
            throw new NullPointerException();
        }

        final String encode64 = codificarACadena(src.getBytes(StandardCharsets.UTF_8));

        return encode64;
    }

    byte[] codificar(final String src) {

        if (StringUtils.isBlank(src)) {
            throw new NullPointerException();
        }

        final byte[] encode64 = codificar(src.getBytes(StandardCharsets.UTF_8));

        return encode64;
    }

    String codificarACadena(final byte[] src) {

        if (src == null) {
            throw new NullPointerException();
        }

        final String encode64 = java.util.Base64.getEncoder().encodeToString(src);

        return encode64;
    }

    @Override
    public byte[] codificar(final byte[] src) {

        if (src == null) {
            throw new NullPointerException();
        }

        final byte[] encode64 = java.util.Base64.getEncoder().encode(src);

        return encode64;
    }

    @Override
    public CodificadorEnum getType() {
        return CodificadorEnum.BASE64;
    }
}