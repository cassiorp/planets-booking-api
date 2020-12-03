package com.forttiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/planetsbooking")
public class Controller {

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public ResultResponse getAllPlanets(@RequestParam(value = "page", required = false) Integer page){
        return this.planetService.getAllPlanets(page);
    }
}
