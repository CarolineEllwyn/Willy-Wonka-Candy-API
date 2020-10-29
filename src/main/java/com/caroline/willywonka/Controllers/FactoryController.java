package com.caroline.willywonka.Controllers;

import com.caroline.willywonka.Models.Repositories.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryController {

    @Autowired
    private FactoryRepository factoryRepository;
}
