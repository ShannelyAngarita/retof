/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Reservacion;
import co.edu.usa.reto3.repositories.RepositoryReservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *Clase donde se encuentran los metodos que se utilizan en el API de reservacion 
 */
@Service
public class ServiceReservacion {

    @Autowired
    /**
     * Variable para interactuar con la base de datos
     */
    private RepositoryReservacion metodosCrud;

    /**
     * Metodo para obtener rodas las reservaciones
     * @return Lista de objetos tipo Reservacion
     */
    public List<Reservacion> getAll() {
        return metodosCrud.getAll();
    }
    
    /**
     * Retorna las observaciones asociadas al parametro
     * @param reservationId entero con la reservacion Id
     * @return  Reservacion asociada al id
     */
    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    
    /**
     * guarda la reservacion en la base de datos
     * @param reservation Objeto tipo reservacion
     * @return El objeto Reservacion guardado
     */
    public Reservacion save(Reservacion reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservacion> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }

        }
    }
    
    /**
     * Actualza la informacion de la reservacion
     * @param reservation Objeto tipo Reservacion
     * @return EL objeto reservacion Actualizado
     */
    public Reservacion update(Reservacion reservation) {
        if (reservation.getIdReservation() == null) {
            Optional<Reservacion> e = metodosCrud.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    /**
     * Borra al reservacion asociada al Id
     * @param reservationId Entero que identifica a la reservacion
     * @return True si todo salio bien y False si ocurrio un erro
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
