package mx.uv.fca.dtos.aplicaciones;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by rafex on 10/09/15.
 */

public class Aplicacion {

    private  String id;
    private  String descripcion;
    private  Boolean estado;

    public Aplicacion(){

    }

    private Aplicacion(AplicacionBuilder aplicacionBuilder){
        this.id = aplicacionBuilder.id;
        this.descripcion = aplicacionBuilder.descripcion;
        this.estado = aplicacionBuilder.estado;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Aplicacion that = (Aplicacion) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(descripcion, that.descripcion)
                .append(estado, that.estado)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(descripcion)
                .append(estado)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Aplicacion{" +
                "id='" + id + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }

    public static class AplicacionBuilder {

        private final String id;
        private final String descripcion;
        private final Boolean estado;

        public AplicacionBuilder(String id, String descripcion,Boolean estado){
            this.id= id;
            this.descripcion = descripcion;
            this.estado= estado;
        }

        public Aplicacion build() {
            return (this.id != null) && (this.descripcion != null) && (this.estado != null) ? new Aplicacion(this) : null;
        }

    }
}
