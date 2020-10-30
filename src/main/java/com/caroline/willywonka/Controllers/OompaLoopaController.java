package com.caroline.willywonka.Controllers;

import com.caroline.willywonka.Models.Factory;
import com.caroline.willywonka.Models.OompaLoompa;

import com.caroline.willywonka.Repositories.OompaLoompaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/oompaloompa")
public class OompaLoopaController {

    @Autowired
    private OompaLoompaRepository oompaLoompaRepository;

    //Get a list of all Oompa Loompas stored in the database
    @GetMapping("/all")
    public ResponseEntity<List<OompaLoompa>> getAllOompaLoompas() {
        List<OompaLoompa> data = oompaLoompaRepository.findAll();
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(data, status);
    }

    //Create a new Oompa Loompa
    @PostMapping
    public ResponseEntity<OompaLoompa> addOompaLoompa(@RequestBody OompaLoompa oompaLoompa) {
        OompaLoompa add = oompaLoompaRepository.save(oompaLoompa);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(add, status);
    }

    //Update existing Oompa Loompa
    //DO NOT WORK

    @PutMapping("/{id}")
    public ResponseEntity<OompaLoompa> updateOompaLoompa(@RequestBody OompaLoompa oompaLoompa ) {
        var oompaLoompaToUpdate = oompaLoompaRepository.findById(oompaLoompa.getId()).get();

        oompaLoompaToUpdate.setId(oompaLoompaToUpdate.getId());
        oompaLoompaToUpdate.setName(oompaLoompaToUpdate.getName());
        oompaLoompaToUpdate.setDob(oompaLoompaToUpdate.getDob());
        oompaLoompaToUpdate.setAddress(oompaLoompaToUpdate.getAddress());
        oompaLoompaRepository.save(oompaLoompaToUpdate);

        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(oompaLoompaToUpdate, status);
    }

    //Delete Oompa Loompa
    @DeleteMapping("/{id}")
    public String deleteOompaLoompa(@PathVariable String id) {
        oompaLoompaRepository.deleteById(Integer.parseInt(id));
        return "Oompa Loompa with id " + id + " was deleted";
    }
}






