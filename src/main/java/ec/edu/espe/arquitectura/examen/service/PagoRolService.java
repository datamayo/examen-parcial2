package ec.edu.espe.arquitectura.examen.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examen.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.examen.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examen.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen.model.Empleado;
import ec.edu.espe.arquitectura.examen.model.EmpleadosPago;
import ec.edu.espe.arquitectura.examen.model.Empresa;
import ec.edu.espe.arquitectura.examen.model.PagoRol;
import ec.edu.espe.arquitectura.examen.repository.PagoRolRepository;

@Service
public class PagoRolService  {
    private final PagoRolRepository pagoRolRepository;

    public PagoRolService(PagoRolRepository pagoRolRepository) {
        this.pagoRolRepository = pagoRolRepository;
    }

    public PagoRol pagoCreate(PagoRolRQ pagoRQ) {
        PagoRol pago = this.transformPagoRQ(pagoRQ);
        PagoRol pagoTmp = this.pagoRolRepository.findFirstByMes(pago.getMes());
        if (pagoTmp == null) {
            pago.setFechaProceso(new Date());
            //aqui va un metodo for
            //pago.setValorTotal(new BigDecimal(0));
            pago.setValorReal(new BigDecimal(0));
            return this.pagoRolRepository.save(pago);
        } else {
            throw new RuntimeException("Ya existe");
        }
    }

    private PagoRol transformPagoRQ(PagoRolRQ rq) {
        List<EmpleadosPago> empleadosPago = this.transformPagosRQ(rq.getPagos());
        PagoRol pago = PagoRol.builder().mes(rq.getMes()).rucEmpresa(rq.getRucEmpresa())
        .cuentaPrincipal(rq.getCuentaPrincipal()).pagos(empleadosPago).build();
        return pago;
    }
    
    private List<EmpleadosPago> transformPagosRQ(List<EmpleadosPagoRQ> rq) {
        List<EmpleadosPago> empleadosPagos = new ArrayList<>();
        for (EmpleadosPagoRQ empleadoPagoRQ : rq) {
            EmpleadosPago empleadoPago = EmpleadosPago.builder().numeroCuenta(empleadoPagoRQ.getNumeroCuenta())
            .valor(empleadoPagoRQ.getValor()).build();
            empleadosPagos.add(empleadoPago);
        }
        return empleadosPagos;
    }
}
