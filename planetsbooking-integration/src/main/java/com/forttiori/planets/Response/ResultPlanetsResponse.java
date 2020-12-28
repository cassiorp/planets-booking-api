package com.forttiori.planets.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultPlanetsResponse {

    private List<PlanetInfoResponse> results;

}
