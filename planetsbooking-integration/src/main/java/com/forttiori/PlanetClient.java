package com.forttiori;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "planets-filter", url = "${planets.filter}")
public interface PlanetClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResultResponse getAllPlanets(@RequestParam("page") Integer page);

//    @RequestMapping(method = RequestMethod.GET, value = "/{id}/")
//    public PlanetInfoResponse getPlanetsById(@PathVariable Integer id);

}
