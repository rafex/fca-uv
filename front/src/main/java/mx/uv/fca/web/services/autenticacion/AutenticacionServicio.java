package mx.uv.fca.web.services.autenticacion;

import mx.uv.fca.web.dtos.autenticacion.AutenticacionFrontInDto;
import mx.uv.fca.web.dtos.autenticacion.AutentificacionFrontOutDto;

/**
 * Created by rafex on 11/09/15.
 */
public interface AutenticacionServicio {

    AutentificacionFrontOutDto autenticacion(AutenticacionFrontInDto entrada);

}
