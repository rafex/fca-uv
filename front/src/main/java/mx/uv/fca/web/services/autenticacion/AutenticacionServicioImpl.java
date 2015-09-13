package mx.uv.fca.web.services.autenticacion;

import mx.uv.fca.core.dtos.ResponseDto;
import mx.uv.fca.core.utilidades.clientes.rest.ClienteRestUtil;
import mx.uv.fca.core.utilidades.json.JSONUtils;
import mx.uv.fca.web.dtos.autenticacion.AutenticacionFrontInDto;
import mx.uv.fca.web.dtos.autenticacion.AutentificacionFrontOutDto;
import mx.uv.fca.web.utilidades.ConstantesFront;
import mx.uv.fca.web.utilidades.sesiones.SesionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by rafex on 11/09/15.
 */
@Service
public class AutenticacionServicioImpl implements AutenticacionServicio {

    @Autowired
    private SesionUtil sesion;


    @Override
    public AutentificacionFrontOutDto autenticacion(AutenticacionFrontInDto entrada) {

        String json = JSONUtils.json(entrada);

        ResponseDto response = ClienteRestUtil.post(ConstantesFront.HOST_REST + "/autenticacion", json, AutentificacionFrontOutDto.class);

        AutentificacionFrontOutDto salida = null;

        if(response != null && response.getBody() != null){
            salida = response.getReturnValue(AutentificacionFrontOutDto.class);
            if(StringUtils.isNotBlank(salida.getKey())){
                final HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
                        .getSession(true);
                session.setAttribute("key",salida.getKey());
            }
        }


        return salida;
    }
}
