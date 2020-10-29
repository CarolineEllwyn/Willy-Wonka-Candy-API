package com.caroline.willywonka.Controllers;
import com.caroline.willywonka.Models.Repositories.OompaLoopaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OompaLoopaController {

    @Autowired
    private OompaLoopaRepository oompaLoopaRepository;


}




