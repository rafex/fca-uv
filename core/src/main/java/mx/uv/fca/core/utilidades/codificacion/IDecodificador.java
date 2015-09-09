package mx.uv.fca.core.utilidades.codificacion;

@FunctionalInterface
public interface IDecodificador {

    byte[] decodificar(byte[] src);

}
