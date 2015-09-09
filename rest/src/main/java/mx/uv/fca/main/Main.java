package mx.uv.fca.main;

import mx.uv.fca.geos.GeoRest;
import mx.uv.fca.utilidades.rest.UtilidadRest;
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

        GeoRest.getListadoEstados();

    }

}
