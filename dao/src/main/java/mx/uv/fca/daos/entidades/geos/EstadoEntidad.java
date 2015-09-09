package mx.uv.fca.daos.entidades.geos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by rafex on 08/09/15.
 */
public class EstadoEntidad {

    private Integer id;
    private String nombre;
    private String abreviacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

        EstadoEntidad that = (EstadoEntidad) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(nombre, that.nombre)
                .append(abreviacion, that.abreviacion)
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
        return "EstadoEntidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", abreviacion='" + abreviacion + '\'' +
                '}';
    }
}
