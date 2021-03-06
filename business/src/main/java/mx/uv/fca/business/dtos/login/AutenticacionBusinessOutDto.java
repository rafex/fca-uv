package mx.uv.fca.business.dtos.login;

import mx.uv.fca.dtos.aplicaciones.Aplicacion;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rafex on 10/09/15.
 */
@XmlRootElement(name = "autenticacion")
@XmlType(name = "autenticacion")
public class AutenticacionBusinessOutDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;
    private Boolean esValida;
    private List<Aplicacion> aplicaciones;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getEsValida() {
        return esValida;
    }

    public void setEsValida(Boolean esValida) {
        this.esValida = esValida;
    }

    public List<Aplicacion> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(List<Aplicacion> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AutenticacionBusinessOutDto that = (AutenticacionBusinessOutDto) o;

        return new EqualsBuilder()
                .append(key, that.key)
                .append(esValida, that.esValida)
                .append(aplicaciones, that.aplicaciones)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(key)
                .append(esValida)
                .append(aplicaciones)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AutenticacionBusinessOutDto{" +
                "key='" + key + '\'' +
                ", esValida=" + esValida +
                ", aplicaciones=" + aplicaciones +
                '}';
    }
}
