package mx.uv.fca.test.utilidades.codificacion;


import mx.uv.fca.enums.CodificadorEnum;

public interface ICodificadorGenerico extends ICodificador, IDecodificador {

    CodificadorEnum getType();

}
