package com.caroline.willywonka.Controllers;

import com.caroline.willywonka.Models.Candy;
import com.caroline.willywonka.Models.Repositories.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CandyController {
    @Autowired
    private CandyRepository candyRepository;

    //Get a list of all candies stored in the database
    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.GET)
    public ArrayList<Candy> getAllCandies() {
        var candies = candyRepository.findAll();
        return (ArrayList<Candy>) candies;
    }

    //Create a new candy
    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.POST)
    public ResponseEntity<Candy> createCandy(@RequestBody Candy candy) {
        candy = candyRepository.save(candy);
        return new ResponseEntity<>(candy, HttpStatus.CREATED);
    }

    //Update existing candy
    @RequestMapping(value = "/api/v1/candies", method = RequestMethod.PUT)
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy candy) {
        var candyToUpdate = candyRepository.findById(candy.getId()).get();

        candyToUpdate.setId(candy.getId());
        candyToUpdate.setName(candy.getName());
        candyToUpdate.setType(candy.getType());
        candyToUpdate.setWeightPerUnit(candy.getWeightPerUnit());
        candyToUpdate.setCostPerUnit(candy.getCostPerUnit());

        candyRepository.save(candyToUpdate);

        return new ResponseEntity<>(candyToUpdate, HttpStatus.OK);
    }

    //Delete candy
    @RequestMapping(value = "/api/v1/candies/{id}")
    public String deleteCandy(@PathVariable String id){
        candyRepository.deleteById(Integer.parseInt(id));
        return "Candy with id " + id + " was deleted";
    }

/*    //Get the total amount of candy records based on type
    @RequestMapping(value = "/api/v1/candies/{type}", method = RequestMethod.GET)
    public ArrayList<Candy> getTotalAmountBasedOnType (@PathVariable String type){
        var allCandies = candyRepository.findAll();
        var sortedByType = new ArrayList<Candy>();

        for(var candy : allCandies){
            if (candy.getType().equals(type)){
                sortedByType.add(candy);
            }
        }

        return sortedByType;
    }*/
}

