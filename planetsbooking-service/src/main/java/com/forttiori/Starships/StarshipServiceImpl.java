package com.forttiori.Starships;

import com.forttiori.Exceptions.StarshipNotFoundException;
import com.forttiori.starships.Response.ResultStarshipsResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import com.forttiori.starships.Service.StarshipsServiceIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StarshipServiceImpl implements StarshipService{

    private final StarshipsServiceIntegration starshipsServiceIntegration;

    @Override
    public ResultStarshipsResponse getAllStarships(Integer page) {
        return this.starshipsServiceIntegration.getAllStarships(page);
    }

    @Override
    public ResultStarshipsResponse getAllStarshipsWithoutPagination() {
        return this.starshipsServiceIntegration.getAllStarshipsWithoutPaginarion();
    }

    @Override
    public StarshipsInfoResponse getStarshipById(Integer id) {
        return this.starshipsServiceIntegration.getStarshipsById(id);
    }

    @Override
    public StarshipsInfoResponse getStarshipByName(String name) {
        Optional<StarshipsInfoResponse> starshipFound = this.starshipsServiceIntegration.getAllStarshipsWithoutPaginarion()
                .getResults().stream()
                .filter(r -> r.getName().equals(name))
                .findFirst();
        if(starshipFound.get() == null) throw new StarshipNotFoundException("Nave não encontrada");
        return starshipFound.get();
    }
}
