package ec.edu.espe.arquitectura.examen.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


import ec.edu.espe.arquitectura.examen.dto.EmpleadosPagoRQ;
import ec.edu.espe.arquitectura.examen.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examen.model.EmpleadosPago;
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
        List<EmpleadosPago> empleadosPagos = pago.getPagos();
        if (pagoTmp == null) {
            pago.setFechaProceso(new Date());
            for(EmpleadosPago empleadosPago : empleadosPagos){
                pago.setValorTotal(empleadosPago.getValor());
            }
            pago.setValorReal(0.0);
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
