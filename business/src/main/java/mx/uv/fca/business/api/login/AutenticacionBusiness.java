package mx.uv.fca.business.api.login;

import mx.uv.fca.business.dtos.login.AutenticacionBusinessInDto;
import mx.uv.fca.business.dtos.login.AutenticacionBusinessOutDto;
import mx.uv.fca.dtos.aplicaciones.Aplicacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafex on 10/09/15.
 */
public class AutenticacionBusiness {

    public static AutenticacionBusinessOutDto firmar(AutenticacionBusinessInDto dtoEntrada){

        AutenticacionBusinessOutDto dtoSalida = new AutenticacionBusinessOutDto();

        dtoSalida.setEsValida(true);
        List<Aplicacion> aplicaciones = new ArrayList<>();
        Aplicacion aplicacion = new Aplicacion.AplicacionBuilder("s098df890s890f890sdfs90","SISSA",true).build();
        aplicaciones.add(aplicacion);
        dtoSalida.setAplicaciones(aplicaciones);


        return dtoSalida;
    }
}
