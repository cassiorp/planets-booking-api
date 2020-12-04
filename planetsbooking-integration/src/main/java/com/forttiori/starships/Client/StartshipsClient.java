package com.forttiori.starships.Client;

import com.forttiori.starships.Response.ResultResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "starships-filter", url = "${starships.filter}")
public interface StartshipsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResultResponse getAllStarships(@RequestParam("page") Integer page);

    @RequestMapping(method = RequestMethod.GET, value = "/all/")
    public ResultResponse getAllStarshipsWithoutPaginarion();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/")
    public StarshipsInfoResponse getStarshipsById(@PathVariable("id") Integer id);

}
