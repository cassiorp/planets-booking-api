package com.forttiori.starships.Service;

import com.forttiori.starships.Client.StartshipsClient;
import com.forttiori.starships.Response.ResultStarshipsResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StarshipsServiceIntegration {
    private final StartshipsClient startshipsClient;

    public ResultStarshipsResponse getAllStarships(Integer page){
        return this.startshipsClient.getAllStarships(page);
    }

    public ResultStarshipsResponse getAllStarshipsWithoutPaginarion(){
        return this.startshipsClient.getAllStarshipsWithoutPaginarion();
    }

    public StarshipsInfoResponse getStarshipsById(Integer id){
        return this.startshipsClient.getStarshipsById(id);
    }
}
