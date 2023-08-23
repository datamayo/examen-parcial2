package ec.edu.espe.arquitectura.examen.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadosPago {
    private String numeroCuenta;
    private Double valor;
    private String estado;
}
