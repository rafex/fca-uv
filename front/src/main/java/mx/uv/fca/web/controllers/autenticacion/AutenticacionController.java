package mx.uv.fca.web.controllers.autenticacion;

import mx.uv.fca.web.dtos.autenticacion.AutenticacionFrontInDto;
import mx.uv.fca.web.dtos.autenticacion.AutentificacionFrontOutDto;
import mx.uv.fca.web.services.autenticacion.AutenticacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rafex on 11/09/15.
 */

@Controller
public class AutenticacionController {

    @Autowired
    private AutenticacionServicio autenticacionServicio;


    @RequestMapping(value = "/publico/autenticacion", method = RequestMethod.POST)
    public @ResponseBody
    AutentificacionFrontOutDto index(@RequestBody AutenticacionFrontInDto entrada) {

        AutentificacionFrontOutDto salida = autenticacionServicio.autenticacion(entrada);

        return salida;
    }

}
