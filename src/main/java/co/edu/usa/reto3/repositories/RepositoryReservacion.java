/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositories;

import co.edu.usa.reto3.repositories.interfaces.InterfaceReservacion;
import co.edu.usa.reto3.model.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ronal
 */
@Repository
public class RepositoryReservacion {

    @Autowired
    private InterfaceReservacion crud4;

    public List<Reservacion> getAll() {
        return (List<Reservacion>) crud4.findAll();
    }

    public Optional<Reservacion> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reservacion save(Reservacion reservation) {
        return crud4.save(reservation);
    }

    public void delete(Reservacion reservation) {
        crud4.delete(reservation);
    }
}
