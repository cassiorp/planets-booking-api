package com.forttiori.Planets;

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
        return this.planetServiceIntegration.getAllPlanets(page);
    }

    @Override
    public ResultPlanetsResponse getAllPlanetsWithoutPagination() {
        return this.planetServiceIntegration.getAllPlanetsWithoutPagination();
    }

    @Override
    public PlanetInfoResponse getPlanetById(Integer id) {
        return this.planetServiceIntegration.getPlanetsById(id);
    }

    @Override
    public PlanetInfoResponse getPlanetsByName(String name) {
       Optional<PlanetInfoResponse> nameFound = this.planetServiceIntegration.getAllPlanetsWithoutPagination()
                .getResults().stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
       if(nameFound.get() == null) throw new PlanetNotFoundException("Planeta não encontrado");
       return nameFound.get();
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
