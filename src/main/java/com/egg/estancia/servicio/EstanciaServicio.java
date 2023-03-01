package com.egg.estancia.servicio;

import com.egg.estancia.entidad.Casa;
import com.egg.estancia.entidad.Cliente;
import com.egg.estancia.entidad.Estancia;
import com.egg.estancia.miexcepcion.MiExcepcion;
import com.egg.estancia.repositorio.IEstanciaRepositorio;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstanciaServicio {

    @Autowired
    private IEstanciaRepositorio estanciaRepositorio;

    @Transactional
    public void crearEstancia(String huesped, LocalDate fechaDesde, LocalDate fechaHasta, Casa casa, Cliente cliente) throws MiExcepcion {
        validar(huesped, fechaDesde, fechaHasta, casa, cliente);
        Estancia estancia = new Estancia();
        estancia.setHuesped(huesped);
        estancia.setFechaDesde(fechaDesde);
        estancia.setFechaHasta(fechaHasta);
        estancia.setCasa(casa);
        estancia.setCliente(cliente);
        estanciaRepositorio.save(estancia);
    }

    @Transactional
    public void editarEstancia(String idEstancia, String huesped, LocalDate fechaDesde, LocalDate fechaHasta, Casa casa, Cliente cliente) throws MiExcepcion {
        validar(huesped, fechaDesde, fechaHasta, casa, cliente);
        Optional<Estancia> respuesta = estanciaRepositorio.findById(idEstancia);
        if (respuesta.isPresent()) {
            Estancia estancia = respuesta.get();
            estancia.setHuesped(huesped);
            estancia.setFechaDesde(fechaDesde);
            estancia.setFechaHasta(fechaHasta);
            estancia.setCasa(casa);
            estancia.setCliente(cliente);
            estanciaRepositorio.save(estancia);
        }
    }

    @Transactional
    public void eliminarEstanciaPorId(String idEstancia) {
        estanciaRepositorio.deleteById(idEstancia);
    }

    @Transactional(readOnly = true)
    public List<Estancia> listarEstancias() {
        return estanciaRepositorio.findAll();
    }

    public void validar(String huesped, LocalDate fechaDesde, LocalDate fechaHasta, Casa casa, Cliente cliente) throws MiExcepcion {
        if (huesped == null || huesped.isEmpty()) {
            throw new MiExcepcion("El huesped no puede ser nulo ni estar vacío.");
        }
        if (fechaDesde == null) {
            throw new MiExcepcion("La fecha de check-in no puede ser nula.");
        }
        if (fechaDesde == null) {
            throw new MiExcepcion("La fecha de check-out no puede ser nula.");
        }
        if (casa == null) {
            throw new MiExcepcion("No ha seleccionado una casa, no sea boludo.");
        }
        if (cliente == null) {
            throw new MiExcepcion("No ha seleccionado un cliente, no sea boludo.");
        }

    }

}
