package com.caroline.willywonka.Controllers;

import com.caroline.willywonka.Models.Factory;
import com.caroline.willywonka.Repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/factory")
public class FactoryController {

    @Autowired
    private FactoryRepository factoryRepository;

    //Get a list of all factories stored in the database
    @GetMapping("/all")
    public ResponseEntity<List<Factory>> getAllFactories() {
        List<Factory> data = factoryRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }

    //Create a new factory
    //A errormessage pops up but the item is added in the database anyway
    @PostMapping
    public ResponseEntity<Factory> addFactory(@RequestBody Factory factory) {
        Factory add = factoryRepository.save(factory);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }

    //Update existing factory
    @PutMapping("/{id}")
    public ResponseEntity<Factory> updateFactory(@RequestBody Factory factory) {
        var factoryToUpdate = factoryRepository.findById(factory.getId()).get();

        factoryToUpdate.setId(factory.getId());
        factoryToUpdate.setName(factory.getName());
        factoryToUpdate.setSize(factory.getSize());
        factoryRepository.save(factoryToUpdate);

        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(factoryToUpdate, status);
    }

    //Delete factory
    @DeleteMapping("/{id}")
    public String deleteFactory(@PathVariable String id) {
        factoryRepository.deleteById(Integer.parseInt(id));
        return "Factory with id " + id + " was deleted";
    }

}

