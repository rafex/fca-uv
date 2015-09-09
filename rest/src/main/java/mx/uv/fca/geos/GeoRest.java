package mx.uv.fca.geos;

import static spark.Spark.get;

/**
 * Created by rafex on 08/09/15.
 */
public class GeoRest {

    public static void getListadoPaises() {
        get(GeoUrlEnum.PAISES.getValor(), (request, response) -> {

            return null;
        });
    }

    public static void getListadoEstados() {
        get(GeoUrlEnum.PAISES.getValor(), (request, response) -> {

            // Aquí debera ir México
            return "{\"algo\":\"valor\"}";
        });
    }



    public enum GeoUrlEnum {

        PAISES("/paises");

        private final String valor;

        private GeoUrlEnum(final String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return this.valor;
        }

    }
}
