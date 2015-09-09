package mx.uv.fca.core.utilidades.codificacion;


import mx.uv.fca.core.enums.CodificadorEnum;

public interface ICodificadorGenerico extends ICodificador, IDecodificador {

    CodificadorEnum getType();

}
