package ec.edu.espe.arquitectura.examen.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpresaRQ {
    private String ruc;
    private String razonSocial;
    private Boolean cuentaPrincipal;
    private List<EmpleadoRQ> empleados;

}
