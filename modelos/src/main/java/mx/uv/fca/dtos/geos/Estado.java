package mx.uv.fca.dtos.geos;

import mx.uv.fca.dtos.Identificador;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by rafex on 09/09/15.
 */
public class Estado {

    private Identificador id;
    private String nombre;
    private String abreviacion;

    public Identificador getId() {
        return id;
    }

    public void setId(Identificador id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return new EqualsBuilder()
                .append(id, estado.id)
                .append(nombre, estado.nombre)
                .append(abreviacion, estado.abreviacion)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(nombre)
                .append(abreviacion)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", abreviacion='" + abreviacion + '\'' +
                '}';
    }
}
