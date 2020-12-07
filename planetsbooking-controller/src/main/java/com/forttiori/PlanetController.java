package com.forttiori;

import com.forttiori.Planets.PlanetService;
import com.forttiori.planets.Response.PlanetInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/planetsbooking/planets")
@RequiredArgsConstructor
public class PlanetController {
    private final PlanetService planetService;

    @GetMapping(value = "/{name}")
    public PlanetInfoResponse getAllPlanetsByClimate(@PathVariable String name) {
        return this.planetService.getPlanetsByName(name);
    }
}
