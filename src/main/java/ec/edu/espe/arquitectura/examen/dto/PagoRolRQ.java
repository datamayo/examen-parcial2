package ec.edu.espe.arquitectura.examen.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoRolRQ {
    private String mes;
    private String rucEmpresa;
    private Boolean cuentaPrincipal;

    private List<EmpleadosPagoRQ> pagos;
}
