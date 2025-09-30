package com.projeto_final.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projeto_final.app.models.Empresa;
import com.projeto_final.app.models.Usuario;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
    List<Empresa> findByUsuario(Usuario usuario);
}
