package org.example.service.impl;

import org.example.dao.FlightsDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.entities.BookingEntity;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;

public class FlightsServiceİmpl implements FlightsService {
    private final FlightsDao flightsDao;

    public FlightsServiceİmpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }


    @Override
    public void  createFlights(FlightsDto flightsDto) {
      FlightsEntity flightsEntity =new FlightsEntity(
              flightsDto.getDateTime(),flightsDto.getFreeSpaces(),flightsDto.getDestination());
              List<FlightsEntity> flightsEntities=flightsDao.getAll().stream().toList();
        flightsEntities.add(flightsEntity);
        flightsDao.save(flightsEntities);
    } //hazir
    @Override
    public Collection<FlightsDto> getAllFlight() {
        ArrayList<FlightsDto>flightsDtos=new ArrayList<>();
        Collection <FlightsEntity>  flightsEntities= flightsDao.getAll();
        flightsEntities.stream().map(flightsDto -> flightsEntities.add(new FlightsEntity(flightsDto.getId(),flightsDto.getDateTime(),flightsDto.getFreeSpaces(),flightsDto.getDestination(),flightsDto.getOrigin())));
        return flightsDtos;

    }//hazir
    @Override
    public Collection<FlightsDto> getAllFlightByOrigin(String origin) {
        return getAllFlight().stream().filter(flightsDto -> flightsDto.getOrigin().equalsIgnoreCase(origin)).toList();
    }//hazir
    @Override
    public Collection<FlightsDto> getAllFlightByDestination(String destination) {

        return getAllFlight().stream().filter(flightsDto -> flightsDto.getDestination().equalsIgnoreCase(destination)).toList();
    }//hazir

    @Override
    public Optional<FlightsDto> getOneFlightByFlightId(long id) {
        return getAllFlight().stream().filter(flightsDto -> flightsDto.getId()==id).findFirst();
    }

    @Override
    public Collection<FlightsDto> getAllFlightByFlightId(long id) {
        return getAllFlight().stream().filter(flightsDto -> flightsDto.getId()==id).toList();

    }

    @Override
    public Collection<FlightsDto> flightsInNext24Hours(String origin, LocalDateTime dateTime) {

        LocalDateTime now=LocalDateTime.now();
        LocalDateTime next24Hours=now.plusHours(24);
        Collection<FlightsDto> allFlights=getAllFlight();
        return  allFlights.stream()
                .filter(flightsDto -> flightsDto.getOrigin().equalsIgnoreCase(origin)&& flightsDto.getDateTime().isAfter(now)&&flightsDto.getDateTime().isBefore(next24Hours)).toList();
    }
}