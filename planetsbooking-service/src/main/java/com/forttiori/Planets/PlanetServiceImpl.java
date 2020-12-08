package com.forttiori.Planets;

import com.forttiori.Exceptions.PageNotFoundException;
import com.forttiori.Exceptions.PlanetNotFoundException;
import com.forttiori.planets.Response.PlanetInfoResponse;
import com.forttiori.planets.Response.ResultPlanetsResponse;
import com.forttiori.planets.Service.PlanetServiceIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetServiceIntegration planetServiceIntegration;

    @Override
    public ResultPlanetsResponse getAllPlanets(Integer page) {
        try {
            return this.planetServiceIntegration.getAllPlanets(page);
        }catch (RuntimeException e) {
            throw new PageNotFoundException(e.getMessage());
        }
    }

    @Override
    public ResultPlanetsResponse getAllPlanetsWithoutPagination() {
        return this.planetServiceIntegration.getAllPlanetsWithoutPagination();
    }

    @Override
    public PlanetInfoResponse getPlanetById(Integer id) {
        try {
            return this.planetServiceIntegration.getPlanetsById(id);
        }catch (RuntimeException e){
            throw new PlanetNotFoundException(e.getMessage());
        }
    }

    @Override
    public PlanetInfoResponse getPlanetsByName(String name) {
       return this.planetServiceIntegration.getAllPlanetsWithoutPagination()
                .getResults().stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new PlanetNotFoundException("Planeta não encontrado"));
    }

    @Override
    public ResultPlanetsResponse getAllPlanetsByClimate(String climate) {
        ResultPlanetsResponse resultPlanetsResponse = this.planetServiceIntegration.getAllPlanetsWithoutPagination();
        List<PlanetInfoResponse> finalResponses = new ArrayList<>();
        resultPlanetsResponse.getResults().stream()
                .filter(r -> r.getClimate().equals(climate))
                .forEach(r -> finalResponses.add(r));
        resultPlanetsResponse.getResults().clear();
        resultPlanetsResponse.setResults(finalResponses);
        return resultPlanetsResponse;
    }
}
