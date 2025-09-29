package com.projeto_final.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.projeto_final.app.models.Usuario;

public interface AppRepository extends CrudRepository<Usuario,String>{
    Usuario findByIdUsuario(long idUsuario);
    Usuario deleteByIdUsuario(long idUsuario);
    Usuario findByEmail(String email);
}
