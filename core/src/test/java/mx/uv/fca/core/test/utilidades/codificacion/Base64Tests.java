package mx.uv.fca.core.test.utilidades.codificacion;

import mx.uv.fca.core.enums.CodificadorEnum;
import mx.uv.fca.core.utilidades.codificacion.Base64;
import mx.uv.fca.core.utilidades.codificacion.CodificadorFactory;
import org.junit.Assert;
import org.junit.Test;

public class Base64Tests {

    @Test
    public void codificacionDeTextoEnBase64() {

         String texto_prueba = "hola mundo infernal";
        final Base64 codificador = (Base64) CodificadorFactory.getInstance(CodificadorEnum.BASE64);
        final byte[] encode = codificador.codificar(texto_prueba.getBytes());

        Assert.assertEquals(texto_prueba, new String(codificador.decodificar(encode)));

    }

}
