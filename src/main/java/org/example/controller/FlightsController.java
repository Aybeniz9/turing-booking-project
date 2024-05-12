package org.example.controller;

import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;
import java.time.LocalDateTime;

import java.util.*;

public class FlightsController {

    private final FlightsService flightsService;

    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;}

    public void createFlights(FlightsDto flightsDto){
        flightsService.createFlights(flightsDto);
    }
    public Collection <FlightsDto> getAllFlight(){
        return flightsService.getAllFlight();
    }
    public Collection<FlightsDto> getAllFlightsByOrigin(String origin){
        return flightsService.getAllFlightByOrigin(origin);
    }
    public Collection<FlightsDto> getAllByDestination (String destination){
        return  flightsService.getAllFlightByDestination(destination);
    }
    public  Collection<FlightsDto> getAllFlightsByFLightId(long id){
        return flightsService.getAllFlightByFlightId(id);
    }
    public Optional<FlightsDto> getOneFlightByFlightId(long id){
        return  flightsService.getOneFlightByFlightId(id);
    }
    public Collection <FlightsDto> getOnlineBoard (String origin, LocalDateTime dateTime){
        return flightsService.flightsInNext24Hours(origin,dateTime);
    }




}
