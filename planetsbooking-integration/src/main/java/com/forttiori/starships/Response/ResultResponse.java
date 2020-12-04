package com.forttiori.starships.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultResponse {

    private List<StarshipsInfoResponse> results = new ArrayList<>();

    public void setResults(List<StarshipsInfoResponse> results) {
        this.results.addAll(results);
    }
}
