package mx.uv.fca.core.utilidades.codificacion;

import mx.uv.fca.core.enums.CodificadorEnum;

import java.util.HashMap;

public class CodificadorFactory {

    private static final HashMap<CodificadorEnum, ICodificadorGenerico> codificadorMap = new HashMap<CodificadorEnum, ICodificadorGenerico>();

    private CodificadorFactory() {
    }

    public static ICodificadorGenerico getInstance(final CodificadorEnum type) {
        switch (type) {
            case BASE64:
                final Base64 codificador = (Base64) codificadorMap.get(type);
                return codificador == null ? new Base64() : codificador;
        }
        return null;
    }
}
