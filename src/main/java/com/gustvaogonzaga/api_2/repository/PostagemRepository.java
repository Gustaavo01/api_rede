package com.gustvaogonzaga.api_2.repository;

import com.gustvaogonzaga.api_2.entities.Postagem;
import com.gustvaogonzaga.api_2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    List<Postagem> findByUsuario(Usuario usuario);
}
