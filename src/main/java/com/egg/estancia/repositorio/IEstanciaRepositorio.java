
package com.egg.estancia.repositorio;

import com.egg.estancia.entidad.Estancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstanciaRepositorio extends JpaRepository<Estancia, String>{
    
}
