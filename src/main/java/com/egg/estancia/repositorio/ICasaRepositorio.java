
package com.egg.estancia.repositorio;

import com.egg.estancia.entidad.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICasaRepositorio extends JpaRepository<Casa, String>{
    
}
