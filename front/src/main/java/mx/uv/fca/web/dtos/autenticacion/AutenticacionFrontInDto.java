package mx.uv.fca.web.dtos.autenticacion;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by rafex on 11/09/15.
 */
public class AutenticacionFrontInDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String usuario;
    private String contrasenya;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AutenticacionFrontInDto that = (AutenticacionFrontInDto) o;

        return new EqualsBuilder()
                .append(usuario, that.usuario)
                .append(contrasenya, that.contrasenya)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(usuario)
                .append(contrasenya)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AutenticacionFrontInDto{" +
                "usuario='" + usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                '}';
    }
}
