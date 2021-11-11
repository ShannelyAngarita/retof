package co.edu.usa.reto3.controllers;

import co.edu.usa.reto3.services.ServiceComputador;
import co.edu.usa.reto3.model.Computador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerComputador {

    @Autowired
    private ServiceComputador servicio;

    @GetMapping("/all")
    public List<Computador> getComputer() {

        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Computador> getComputers(@PathVariable("id") int computerId) {

        return servicio.getComputer(computerId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador save(@RequestBody Computador computer) {
        return servicio.save(computer);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computador update(@RequestBody Computador computer) {
        return servicio.update(computer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int computerId) {
        return servicio.deleteComputer(computerId);
    }

    @DeleteMapping("/all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAll() {
        return servicio.deleteAll();
    }
}
