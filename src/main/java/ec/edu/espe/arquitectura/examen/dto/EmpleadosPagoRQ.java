package ec.edu.espe.arquitectura.examen.dto;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadosPagoRQ {
    private String numeroCuenta;
    private Double valor;
}
