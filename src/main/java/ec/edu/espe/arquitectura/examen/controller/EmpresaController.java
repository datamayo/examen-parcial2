package ec.edu.espe.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.model.Empresa;
import ec.edu.espe.arquitectura.examen.service.EmpresaService;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public ResponseEntity<Empresa> empresaCreate(@RequestBody EmpresaRQ empresa) {
        try {
            Empresa empresaRS = this.empresaService.empresaCreate(empresa);
            return ResponseEntity.ok(empresaRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    
}
