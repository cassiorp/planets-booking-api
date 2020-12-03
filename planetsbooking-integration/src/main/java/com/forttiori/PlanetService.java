package com.forttiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class PlanetService {

    @Autowired
    private PlanetClient planetClient;

    @GetMapping
    public ResultResponse getAllPlanets(@RequestParam("page") Integer page){
        return this.planetClient.getAllPlanets(page);
    }

}
