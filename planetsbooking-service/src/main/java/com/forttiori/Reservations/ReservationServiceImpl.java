package com.forttiori.Reservations;

import com.forttiori.DTO.ReservationDTO;
import com.forttiori.Entity.Reservation;
import com.forttiori.Planets.PlanetService;
import com.forttiori.Repository.ReservationRepository;
import com.forttiori.Starships.StarshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final PlanetService planetService;
    private final StarshipService starshipService;

    @Override
    public Reservation save(ReservationDTO reservationDTO) {
        this.planetService.getPlanetsByName(reservationDTO.getPlanet());
        this.starshipService.getStarshipByName(reservationDTO.getStarship());
        return this.reservationRepository.save(
                new Reservation(reservationDTO.getPlanet(),
                                reservationDTO.getStarship(),
                                reservationDTO.getDate()));
    }

    @Override
    public List<Reservation> findAll() {
        return this.reservationRepository.findAll();
    }

    @Override
    public Reservation upDate(String id, ReservationDTO reservationDTO) {
        this.planetService.getPlanetsByName(reservationDTO.getPlanet());
        this.starshipService.getStarshipByName(reservationDTO.getStarship());
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        reservation.get().setPlanet(reservationDTO.getPlanet());
        reservation.get().setStarship(reservationDTO.getStarship());
        reservation.get().setDate(reservationDTO.getDate());
        return this.reservationRepository.save(reservation.get());
    }

    @Override
    public void delete(String id) {
        this.reservationRepository.deleteById(id);
    }


}
