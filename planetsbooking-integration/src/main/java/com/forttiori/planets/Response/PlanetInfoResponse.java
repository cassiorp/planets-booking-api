package com.forttiori.planets.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetInfoResponse {

    private String name;
    private String climate;

}
