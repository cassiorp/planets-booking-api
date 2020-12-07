package com.forttiori.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    @NotNull
    @NotEmpty
    private String planet;

    @NotNull
    @NotEmpty
    private String starship;

    @NotNull
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy" )
    private Date date;

}
