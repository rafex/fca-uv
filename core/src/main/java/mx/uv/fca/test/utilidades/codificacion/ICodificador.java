package mx.uv.fca.test.utilidades.codificacion;

@FunctionalInterface
public interface ICodificador {

    byte[] codificar(byte[] src);
}
