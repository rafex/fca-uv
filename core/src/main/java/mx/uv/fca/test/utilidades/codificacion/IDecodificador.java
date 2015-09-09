package mx.uv.fca.test.utilidades.codificacion;

@FunctionalInterface
public interface IDecodificador {

    byte[] decodificar(byte[] src);

}
