package com.forttiori.Starships;

import com.forttiori.Exceptions.PageNotFoundException;
import com.forttiori.Exceptions.StarshipNotFoundException;
import com.forttiori.starships.Response.ResultStarshipsResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import com.forttiori.starships.Service.StarshipsServiceIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class StarshipServiceImpl implements StarshipService{

    private final StarshipsServiceIntegration starshipsServiceIntegration;

    @Override
    public ResultStarshipsResponse getAllStarships(Integer page) {
        try {
            return this.starshipsServiceIntegration.getAllStarships(page);
        }catch (RuntimeException e){
            throw new PageNotFoundException(e.getMessage());
        }
    }

    @Override
    public ResultStarshipsResponse getAllStarshipsWithoutPagination() {
        return this.starshipsServiceIntegration.getAllStarshipsWithoutPaginarion();
    }

    @Override
    public StarshipsInfoResponse getStarshipById(Integer id) {
        try {
            return this.starshipsServiceIntegration.getStarshipsById(id);
        }catch (RuntimeException e){
            throw new StarshipNotFoundException(e.getMessage());
        }
    }

    @Override
    public StarshipsInfoResponse getStarshipByName(String name) {
      return this.starshipsServiceIntegration.getAllStarshipsWithoutPaginarion()
                .getResults().stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new StarshipNotFoundException("Nave não encontrada"));
    }
}
