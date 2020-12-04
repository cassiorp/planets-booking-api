package com.forttiori.starships.Service;

import com.forttiori.starships.Client.StartshipsClient;
import com.forttiori.starships.Response.ResultResponse;
import com.forttiori.starships.Response.StarshipsInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class StarshipsService {
    private final StartshipsClient startshipsClient;

    public ResultResponse getAllStarships(Integer page){
        return this.startshipsClient.getAllStarships(page);
    }

    public ResultResponse getAllStarshipsWithoutPaginarion(){
        return this.startshipsClient.getAllStarshipsWithoutPaginarion();
    }

    public StarshipsInfoResponse getStarshipsById(Integer id){
        return this.startshipsClient.getStarshipsById(id);
    }
}
