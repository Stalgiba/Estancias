
package com.egg.estancia.repositorio;

import com.egg.estancia.entidad.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamiliaRepositorio extends JpaRepository<Familia, String>{
    
}
