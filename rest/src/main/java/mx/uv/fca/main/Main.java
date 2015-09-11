package mx.uv.fca.main;

import mx.uv.fca.core.utilidades.rest.UtilidadRest;
import mx.uv.fca.rest.api.catalogos.GeneralCatalogoRest;
import mx.uv.fca.rest.api.autenticacion.AutenticacionRest;
import spark.servlet.SparkApplication;

import static spark.Spark.before;

/**
 * Created by rafex on 08/09/15.
 */
public class Main implements SparkApplication {

    @Override
    public void init() {

        before((request, response) -> {
            UtilidadRest.setApplicationType(request, response);
        });

        AutenticacionRest.firmar();

        GeneralCatalogoRest.getListadoEstados();
    }

}
