package ec.edu.espe.arquitectura.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ec.edu.espe.arquitectura.examen.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    Empresa findFirstByRuc(String ruc);
}
