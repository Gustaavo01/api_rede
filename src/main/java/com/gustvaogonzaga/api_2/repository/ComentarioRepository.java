package com.gustvaogonzaga.api_2.repository;

import com.gustvaogonzaga.api_2.entities.Comentario;
import com.gustvaogonzaga.api_2.entities.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
        List<Comentario> findByPostagem(Postagem postagem);
}
