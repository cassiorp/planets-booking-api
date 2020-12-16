package com.forttiori;

import com.forttiori.Starships.StarshipService;
import com.forttiori.starships.Response.ResultStarshipsResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/planetsbooking/starships")
@RequiredArgsConstructor
public class StarshipController {

    private final StarshipService starshipService;

    @GetMapping
    public ResultStarshipsResponse getAll(@RequestParam(value = "page", required = false) Integer page){
        return this.starshipService.getAllStarships(page);
    }

    @GetMapping("/{name}")
    public StarshipsInfoResponse getStarshipByName(@PathVariable String name){
        return this.starshipService.getStarshipByName(name);
    }

    @GetMapping("/id/{id}")
    public StarshipsInfoResponse getStarshipById(@PathVariable Integer id){
        return this.starshipService.getStarshipById(id);
    }

}
