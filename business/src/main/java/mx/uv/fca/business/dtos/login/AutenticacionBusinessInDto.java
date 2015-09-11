package mx.uv.fca.business.dtos.login;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by rafex on 10/09/15.
 */
public class AutenticacionBusinessInDto {

    private String usuario;
    private String contrasenya;
    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AutenticacionBusinessInDto that = (AutenticacionBusinessInDto) o;

        return new EqualsBuilder()
                .append(usuario, that.usuario)
                .append(contrasenya, that.contrasenya)
                .append(key, that.key)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(usuario)
                .append(contrasenya)
                .append(key)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AutenticacionBusinessInDto{" +
                "usuario='" + usuario + '\'' +
                ", contrasenya='" + contrasenya + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
