package mx.uv.fca.core.utilidades.codificacion;

@FunctionalInterface
public interface ICodificador {

    byte[] codificar(byte[] src);
}
