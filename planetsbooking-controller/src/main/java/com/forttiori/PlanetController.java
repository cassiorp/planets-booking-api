package com.forttiori;

import com.forttiori.Planets.PlanetService;
import com.forttiori.planets.Response.PlanetInfoResponse;
import com.forttiori.planets.Response.ResultPlanetsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/planetsbooking/planets")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping
    public ResultPlanetsResponse getAll(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "climate", required = false) String climate){
        if(climate != null)
            return this.planetService.getAllPlanetsByClimate(climate);
        return this.planetService.getAllPlanets(page);
    }

    @GetMapping(value = "/{name}")
    public PlanetInfoResponse getPlanetByName(@PathVariable String name) {
        return this.planetService.getPlanetsByName(name);
    }

    @GetMapping(value = "/id/{id}")
    public PlanetInfoResponse getPlanetById(@PathVariable Integer id){
        return this.planetService.getPlanetById(id);
    }
}
