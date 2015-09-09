package mx.uv.fca.utilidades.codificacion;

@FunctionalInterface
public interface IDecodificador {

    byte[] decodificar(byte[] src);

}
