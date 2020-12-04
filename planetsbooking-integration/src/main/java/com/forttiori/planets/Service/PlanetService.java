package com.forttiori.planets.Service;

import com.forttiori.planets.Client.PlanetClient;
import com.forttiori.planets.Response.PlanetInfoResponse;
import com.forttiori.planets.Response.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetClient planetClient;

    public ResultResponse getAllPlanets(Integer page){
        return this.planetClient.getAllPlanets(page);
    }

    public ResultResponse getAllStarshipsWithoutPagination(){
        return this.planetClient.getAllStarshipsWithoutPagination();
    }

    public PlanetInfoResponse getPlanetsById(Integer id){
        return this.planetClient.getPlanetsById(id);
    }


}
