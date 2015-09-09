package mx.uv.fca.rest.api.catalogos;

import mx.uv.fca.business.api.catalogos.GeneralCatalogoBusiness;
import mx.uv.fca.business.dtos.catalogos.ListadoEstadosBusinessOutDto;
import mx.uv.fca.core.utilidades.rest.UtilidadRest;

import static spark.Spark.get;

/**
 * Created by rafex on 09/09/15.
 */
public class GeneralCatalogoRest {

    private static String BASE_URL = "/catalogo";
    private static String ESTADOS_URL = BASE_URL + "/estados";

    public static void getListadoEstados() {
        get(ESTADOS_URL, (request, response) -> {

            ListadoEstadosBusinessOutDto salida = GeneralCatalogoBusiness.estados();

            return UtilidadRest.generarSalida(request, salida);
        });
    }
}
