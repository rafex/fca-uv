package mx.uv.fca.daos.api.geos;

import mx.uv.fca.daos.dtos.geos.Estados;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created by rafex on 08/09/15.
 */
public class ListadoEstadosDaoOutDto {

    private List<Estados> estados;

    public ListadoEstadosDaoOutDto(List<Estados> estados) {
        this.estados = estados;
    }

    public List<Estados> getEstados() {
        return estados;
    }

    public void setEstados(List<Estados> estados) {
        this.estados = estados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ListadoEstadosDaoOutDto that = (ListadoEstadosDaoOutDto) o;

        return new EqualsBuilder()
                .append(estados, that.estados)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(estados)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ListadoEstadosDaoOutDto{" +
                "estados=" + estados +
                '}';
    }
}
