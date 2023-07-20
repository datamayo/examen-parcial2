package ec.edu.espe.arquitectura.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.model.Empleado;
import ec.edu.espe.arquitectura.examen.model.Empresa;
import ec.edu.espe.arquitectura.examen.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa empresaCreate(EmpresaRQ empresaRQ) {
        Empresa empresa = this.transformEmpresaRQ(empresaRQ);
        Empresa empresaTmp = this.empresaRepository.findFirstByRuc(empresa.getRuc());
        if (empresaTmp == null) {
            return this.empresaRepository.save(empresa);
        } else {
            throw new RuntimeException("Empresa con ruc " + empresa.getRuc() + " ya existe");
        }
    }

    private Empresa transformEmpresaRQ(EmpresaRQ rq) {
        List<Empleado> empleados = this.transformEmpleadosRQ(rq.getEmpleados());
        Empresa empresa = Empresa.builder().ruc(rq.getRuc()).razonSocial(rq.getRazonSocial())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleados(empleados).build();
        return empresa;
    }

    private List<Empleado> transformEmpleadosRQ(List<EmpleadoRQ> rq) {
        List<Empleado> empleados = new ArrayList<>();
        for (EmpleadoRQ empleadoRQ : rq) {
            Empleado empleado = Empleado.builder().cedula(empleadoRQ.getCedula()).apellidos(empleadoRQ.getApellidos())
                    .nombres(empleadoRQ.getNombres()).numeroCuenta(empleadoRQ.getNumeroCuenta()).build();
            empleados.add(empleado);
        }
        return empleados;
    }

}
