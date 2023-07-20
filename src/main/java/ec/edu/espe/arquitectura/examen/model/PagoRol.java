package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "roles")
public class PagoRol {
    @Id
    private String id;
    private String mes;
    private Date fechaProceso;
    private String rucEmpresa;
    private Boolean cuentaPrincipal;
    private BigDecimal valorTotal;
    private BigDecimal valorReal;

    @Version 
    private Long version;

    private List<EmpleadosPago> pagos;
    
    
}
