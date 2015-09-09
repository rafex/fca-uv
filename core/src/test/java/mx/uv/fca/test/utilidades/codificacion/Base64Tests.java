package mx.uv.fca.test.utilidades.codificacion;

import mx.uv.fca.enums.CodificadorEnum;
import mx.uv.fca.utilidades.codificacion.Base64;
import mx.uv.fca.utilidades.codificacion.CodificadorFactory;
import org.junit.Assert;
import org.junit.Test;

public class Base64Tests {

    @Test
    public void codificacionDeTextoEnBase64() {

        final String texto_prueba = "hola mundo infernal";
        final Base64 codificador = (Base64) CodificadorFactory.getInstance(CodificadorEnum.BASE64);
        final byte[] encode = codificador.codificar(texto_prueba);

        Assert.assertEquals(texto_prueba, new String(codificador.decodificar(encode)));

    }

}
