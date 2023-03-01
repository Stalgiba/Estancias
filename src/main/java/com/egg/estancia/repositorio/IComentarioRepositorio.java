
package com.egg.estancia.repositorio;

import com.egg.estancia.entidad.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepositorio extends JpaRepository<Comentario, String>{
    
}
