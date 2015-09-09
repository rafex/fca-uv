package mx.uv.fca.business.dtos.catalogos;

import mx.uv.fca.dtos.geos.Estado;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

/**
 * Created by rafex on 09/09/15.
 */
public class ListadoEstadosBusinessOutDto {

    private List<Estado> estados;

    public ListadoEstadosBusinessOutDto(){
    }

    public ListadoEstadosBusinessOutDto(List<Estado> estados){
        this.estados = estados;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListadoEstadosBusinessOutDto that = (ListadoEstadosBusinessOutDto) o;
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
        return "ListadoEstadosBusinessOutDto{" +
                "estados=" + estados +
                '}';
    }
}
