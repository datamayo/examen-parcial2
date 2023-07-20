package ec.edu.espe.arquitectura.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen.model.PagoRol;

public interface PagoRolRepository extends MongoRepository<PagoRol, String>{
    PagoRol findFirstByMes(String mes);
}
