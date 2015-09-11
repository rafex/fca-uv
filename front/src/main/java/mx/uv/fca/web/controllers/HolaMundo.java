package mx.uv.fca.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by rafex on 11/09/15.
 */
@Controller
public class HolaMundo {

    @RequestMapping(value = "/persona",
            method = RequestMethod.GET)
    public @ResponseBody
    Persona index(Map<String, Object> model) {

        Persona p = new Persona("Raul");


        return p;
    }
    @RequestMapping(value = "/privado/persona",
            method = RequestMethod.GET)
    public @ResponseBody
    Persona indexx(Map<String, Object> model) {

        Persona p = new Persona("Raul");


        return p;
    }

    public class Persona {
        private String nombre;

        public Persona(){

        }

        public Persona(String nombre){
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
}
