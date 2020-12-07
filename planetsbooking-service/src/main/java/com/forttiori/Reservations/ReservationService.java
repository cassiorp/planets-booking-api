package com.forttiori.Reservations;

import com.forttiori.DTO.ReservationDTO;
import com.forttiori.Entity.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation save(ReservationDTO reservationDTO);
    public List<Reservation> findAll();
    public Reservation upDate(String id, ReservationDTO reservationDTO);
    public void delete(String id);

}
