package mx.uv.fca.web.services.autenticacion;

import mx.uv.fca.core.dtos.ResponseDto;
import mx.uv.fca.core.utilidades.clientes.rest.ClienteRestUtil;
import mx.uv.fca.core.utilidades.json.JSONUtils;
import mx.uv.fca.web.dtos.autenticacion.AutenticacionFrontInDto;
import mx.uv.fca.web.dtos.autenticacion.AutentificacionFrontOutDto;
import mx.uv.fca.web.utilidades.ConstantesFront;
import org.springframework.stereotype.Service;

/**
 * Created by rafex on 11/09/15.
 */
@Service
public class AutenticacionServicioImpl implements AutenticacionServicio {

    @Override
    public AutentificacionFrontOutDto autenticacion(AutenticacionFrontInDto entrada) {

        String json = JSONUtils.json(entrada);

        ResponseDto response = ClienteRestUtil.post(ConstantesFront.HOST_REST + "/autenticacion", json, AutentificacionFrontOutDto.class);

        return response.getReturnValue(AutentificacionFrontOutDto.class);
    }
}
