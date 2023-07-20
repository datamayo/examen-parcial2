package ec.edu.espe.arquitectura.examen.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "empresas")
public class Empresa {
    @Id
    private String id;
    @Indexed(unique = true)
    private String ruc;
    private String razonSocial;
    private Boolean cuentaPrincipal;
    
    @Version
    private Long version;

    private List<Empleado> empleados;
    
}
