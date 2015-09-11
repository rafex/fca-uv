package mx.uv.fca.rest.api.autenticacion;

import mx.uv.fca.business.api.login.AutenticacionBusiness;
import mx.uv.fca.business.dtos.login.AutenticacionBusinessInDto;
import mx.uv.fca.business.dtos.login.AutenticacionBusinessOutDto;
import mx.uv.fca.core.utilidades.rest.UtilidadRest;

import static spark.Spark.post;

/**
 * Created by rafex on 10/09/15.
 */
public class AutenticacionRest {

    private static String BASE_URL = "/autenticacion";

    public static void firmar() {
        post(BASE_URL, (request, response) -> {
            AutenticacionBusinessInDto dtoEntrada = UtilidadRest.leerBody(request,AutenticacionBusinessInDto.class);
            AutenticacionBusinessOutDto salida = AutenticacionBusiness.firmar(dtoEntrada);
            return UtilidadRest.generarSalida(request, salida);
        });
    }


}
