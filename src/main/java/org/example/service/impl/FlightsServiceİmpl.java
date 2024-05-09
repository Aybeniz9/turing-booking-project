package org.example.service.impl;

import org.example.dao.FlightsDao;
import org.example.dao.impl.FlightsFileDao;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;

import java.time.LocalDateTime;
import java.util.*;

public class FlightsServiceİmpl implements FlightsService {
    private final FlightsDao flightsDao;

    public FlightsServiceİmpl(FlightsDao flightsDao) {
        this.flightsDao = flightsDao;
    }

    private FlightsFileDao flightsFileDao;

    public List<FlightsEntity> getAllFlightsFromKievNext24Hours() {
        List<FlightsEntity> allFlights = flightsFileDao.getAllFLights();
        List<FlightsEntity> flightsFromKievNext24Hours = new ArrayList<>();
        for (FlightsEntity flight : allFlights) {
            if (isFromKiev(flight.getDestination()) && isWithinNext24Hours(flight.getDate())) {
                flightsFromKievNext24Hours.add(flight);
            }
        }

        return flightsFromKievNext24Hours;
    }


    private boolean isFromKiev(String destination) {
        return destination.equalsIgnoreCase("Kiev");
    }

    private boolean isWithinNext24Hours(LocalDateTime dateTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24Hours = now.plusHours(24);
        return dateTime.isAfter(now) && dateTime.isBefore(next24Hours);
    }

    @Override
    public FlightsDto displayOnlineBoard(FlightsDto flightsDto) {
        return null;
    }


    @Override
    public FlightsEntity getFlightById(String flight_id) {
        return flightsDao.getFlightById(flight_id);
    }



    @Override
    public String searchBookFlight(FlightsDto flightsDto) {
        return null;
    }

    @Override
    public List<FlightsEntity> searchFlights(String destination, String date, int numPeople) {
        return flightsDao.searchFlights(destination, date, numPeople); // Delegate to DAO
    }

}
}
