package ec.edu.espe.arquitectura.examen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen.model.Empresa;
import ec.edu.espe.arquitectura.examen.model.PagoRol;
import ec.edu.espe.arquitectura.examen.service.PagoRolService;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoRolController {
    private final PagoRolService pagoRolService;

    public PagoRolController(PagoRolService pagoRolService) {
        this.pagoRolService = pagoRolService;
    }
    

    @PostMapping
    public ResponseEntity<PagoRol> empresaCreate(@RequestBody PagoRolRQ pagoRol) {
        try {
            PagoRol pagoRolRS = this.pagoRolService.pagoCreate(pagoRol);
            return ResponseEntity.ok(pagoRolRS);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }
}
