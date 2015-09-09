package mx.uv.fca.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

/**
 * Created by rafex on 08/09/15.
 */
public class Identificador {

    private String id;
    private String idInterno;

    public Identificador(String id, String idInterno) {
        this.id = id + UUID.randomUUID().toString();
        this.idInterno = idInterno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public String getIdInterno() {
        return idInterno;
    }

    @JsonIgnore
    public void setIdInterno(String idInterno) {
        this.idInterno = idInterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Identificador that = (Identificador) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(idInterno, that.idInterno)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(idInterno)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Identificador{" +
                "id='" + id + '\'' +
                ", idInterno='" + idInterno + '\'' +
                '}';
    }
}
