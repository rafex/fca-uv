package mx.uv.fca.utilidades.codificacion;

@FunctionalInterface
public interface ICodificador {

    byte[] codificar(byte[] src);
}
