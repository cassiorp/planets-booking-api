package com.forttiori.planets.Service;

import com.forttiori.planets.Client.PlanetClient;
import com.forttiori.planets.Response.PlanetInfoResponse;
import com.forttiori.planets.Response.ResultPlanetsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanetServiceIntegration {

    private final PlanetClient planetClient;

    public ResultPlanetsResponse getAllPlanets(Integer page){
        return this.planetClient.getAllPlanets(page);
    }

    public ResultPlanetsResponse getAllPlanetsWithoutPagination(){
        return this.planetClient.getAllPlanetsWithoutPagination();
    }

    public PlanetInfoResponse getPlanetsById(Integer id){
        return this.planetClient.getPlanetsById(id);
    }


}
