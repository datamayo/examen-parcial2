package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadosPago {
    private String numeroCuenta;
    private BigDecimal valor;
    private String estado;
}
