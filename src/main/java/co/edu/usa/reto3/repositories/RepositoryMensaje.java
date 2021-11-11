/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositories;

import co.edu.usa.reto3.repositories.interfaces.InterfaceMensaje;
import co.edu.usa.reto3.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryMensaje {

    @Autowired
    private InterfaceMensaje crud3;

    public List<Mensaje> getAll() {
        return (List<Mensaje>) crud3.findAll();
    }

    public Optional<Mensaje> getMessage(int id) {
        return crud3.findById(id);
    }

    public Mensaje save(Mensaje message) {
        return crud3.save(message);
    }

    public void delete(Mensaje message) {
        crud3.delete(message);
    }
}
