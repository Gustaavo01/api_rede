package com.gustvaogonzaga.api_2.repository;

import com.gustvaogonzaga.api_2.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
