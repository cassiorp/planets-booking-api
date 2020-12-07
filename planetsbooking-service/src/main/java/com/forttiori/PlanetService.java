package com.forttiori;

import com.forttiori.planets.Response.PlanetInfoResponse;
import com.forttiori.planets.Response.ResultPlanetsResponse;
import org.springframework.stereotype.Service;

@Service
public interface PlanetService {

    public ResultPlanetsResponse getAllPlanets(Integer page);
    public ResultPlanetsResponse getAllPlanetsWithoutPagination();
    public PlanetInfoResponse getPlanetById(Integer id);
    public PlanetInfoResponse getPlanetsByName(String name);
    public ResultPlanetsResponse getAllPlanetsByClimate(String climate);

}
