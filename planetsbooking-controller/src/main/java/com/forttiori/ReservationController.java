package com.forttiori;


import com.forttiori.DTO.ReservationDTO;
import com.forttiori.Entity.Reservation;
import com.forttiori.Reservations.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/planetsbooking")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public Reservation save(@RequestBody @Valid ReservationDTO reservationDTO){
        return this.reservationService.save(reservationDTO);
    }

    @GetMapping
    public List<Reservation> findAll(){
        return this.reservationService.findAll();
    }

    @PutMapping(value = "/{id}")
    public Reservation update(@PathVariable String id, @RequestBody @Valid ReservationDTO reservationDTO){
        return this.reservationService.upDate(id, reservationDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        this.reservationService.delete(id);
    }

}
