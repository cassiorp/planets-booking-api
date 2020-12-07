package com.forttiori;

import com.forttiori.starships.Response.ResultStarshipsResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;

public interface StarshipService {

    public ResultStarshipsResponse getAllStarships(Integer page);
    public ResultStarshipsResponse getAllStarshipsWithoutPagination();
    public StarshipsInfoResponse getStarshipById(Integer id);
    public StarshipsInfoResponse getStarshipByName(String name);

}
