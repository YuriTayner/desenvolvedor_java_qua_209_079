package com.projeto_final.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projeto_final.app.models.Catalogo;
import com.projeto_final.app.models.Empresa;

public interface CatalogoRepository extends CrudRepository<Catalogo, Long> {
    List<Catalogo> findByEmpresa(Empresa empresa);
    Catalogo findByIdCatalogo(long idCatalogo);
}
