package com.forttiori.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Data
@Document(collection = "reservations")
@NoArgsConstructor
public class Reservation {
    @Id
    private String id;

    private String planet;

    private String starship;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy" )
    private Date date;

    public Reservation(String planet, String starship, Date date) {
        this.planet = planet;
        this.starship = starship;
        this.date = date;
    }
}
