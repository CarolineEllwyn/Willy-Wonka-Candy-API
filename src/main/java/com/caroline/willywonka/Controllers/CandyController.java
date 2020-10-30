package com.caroline.willywonka.Controllers;

import com.caroline.willywonka.Models.Candy;
import com.caroline.willywonka.Repositories.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/candy")
public class CandyController {
    @Autowired
    private CandyRepository candyRepository;

    //Get a list of all candies stored in the database
    @GetMapping("/all")
    public ArrayList<Candy> getAllCandies() {
        var candies = candyRepository.findAll();
        return (ArrayList<Candy>) candies;
    }

    //Create a new candy
    @PostMapping
    public ResponseEntity<Candy> createCandy(@RequestBody Candy candy) {
        candy = candyRepository.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.CREATED);
    }

    //Update existing candy
    @PutMapping("{id}")
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy candy) {
        var candyToUpdate = candyRepository.findById(candy.getId()).get();

        candyToUpdate.setId(candy.getId());
        candyToUpdate.setName(candy.getName());
        candyToUpdate.setType(candy.getType());
        candyToUpdate.setWeightPerUnit(candy.getWeightPerUnit());
        candyToUpdate.setCostPerUnit(candy.getCostPerUnit());

        candyRepository.save(candyToUpdate);
        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(candyToUpdate, status);
    }

    //Delete candy
    @DeleteMapping("/{id}")
    public String deleteCandy(@PathVariable String id) {
        candyRepository.deleteById(Integer.parseInt(id));
        return "Candy with id " + id + " was deleted";
    }

    //Get the total amount of candy records based on type.
    //This method is under construction
/*
    @RequestMapping(value = "/api/v1/candies/totalAmount", method = RequestMethod.GET)
    public HashMap<String, Integer> getTotalAmountBasedOnType (){
        var allCandies = candyRepository.findAll();
        var totalAmount = new HashMap<String, Integer>();

        for (var t: allCandies) {
            if (totalAmount.containsKey(t)){
                totalAmount.put( t.getWeightPerUnit(), totalAmount.get(t)+1);
            }
            else totalAmount.put(t.getType(), 1);

        }

        return totalAmount;
    }*/
}






