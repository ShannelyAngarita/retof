/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositories;

import co.edu.usa.reto3.repositories.interfaces.InterfaceComputador;
import co.edu.usa.reto3.model.Computador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ronal
 */
@Repository
public class RepositoryComputador {

    @Autowired
    private InterfaceComputador crud;

    public List<Computador> getAll(){
        return (List<Computador>) crud.findAll();
    }

    public Optional<Computador> getComputer(int id){
        return crud.findById(id);
    }

    public Computador save(Computador computer){
        return crud.save(computer);
    }
    
    public void delete(Computador computer){
        crud.delete(computer);
    }
    
    public boolean deleteAll(){
        crud.deleteAll();
        return crud.count()==0;
    }
}
