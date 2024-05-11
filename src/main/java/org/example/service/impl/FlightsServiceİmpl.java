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
              flightsDto.getDateTime(),flightsDto.getDestination(), flightsDto.getFreeSpaces();
              Collection <FlightsEntity> flightsEntities=flightsDao.getAll();
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
    public void delete(long id) {

    }

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
//    @Override
//    public Collection<FlightsDto> findAllFlight() {
//
//    }
//
//    @Override
//    public Optional<FlightsDto> findFlightId(Predicate<FlightsDto> predicate) {
//        Optional<FlightsDto> findFlight= getAllFlight().stream().filter(predicate).findFirst();
//        return findFlight;
//    }

//    public List<FlightsEntity> getAllFlightsFromKievNext24Hours() {
//        List<FlightsEntity> allFlights = flightsFileDao.getAllFlights();
//        List<FlightsEntity> flightsFromKievNext24Hours = new ArrayList<>();
//        for (FlightsEntity flight : allFlights) {
//            if (isFromKiev(flight.getDestination()) && isWithinNext24Hours(flight.getDateTime())) {
//                flightsFromKievNext24Hours.add(flight);
//            }
//        }
//
//        return flightsFromKievNext24Hours;
//    }
//
//
//    private boolean isFromKiev(String destination) {
//        return destination.equalsIgnoreCase("Kiev");
//    }
//
//    private boolean isWithinNext24Hours(LocalDateTime dateTime) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime next24Hours = now.plusHours(24);
//        return dateTime.isAfter(now) && dateTime.isBefore(next24Hours);
//    }
//
//
//    @Override
//    public List<FlightsEntity> searchAvailableFlights(String destination, String date, int numPassengers) {
//        List<FlightsEntity> availableFlights = new ArrayList<>();
//        List<FlightsEntity> allFlights = flightsDao.getAllFlights();
//
//        for (FlightsEntity flight : allFlights) {
//            if (flight.getDestination().equalsIgnoreCase(destination) &&
//                    flight.getDateTime().equals(date) &&
//                    flight.getFreeSpaces()>= numPassengers) {
//                availableFlights.add(flight);
//            }
//        }
//
//        return availableFlights;
//    }
//
//    @Override
//    public List<FlightsEntity> getMyFlights(String name) {
//        return null;
//    }
//
////    //@Override
////    public boolean bookFlight(String flightId, List<String> passengerNames) {
////        FlightsEntity flight = flightsDao.getFlightById(flightId);
////        if (flight == null) {
////            return false;
////        }
////
////        if (flight.getFreeSpaces()< passengerNames.size()) {
////            return false;
////        }
////
////        // Reduce available seats
////        flight.setFreeSpaces(flight.getFreeSpaces()- passengerNames.size());
////
////        // Create booking for each passenger
////        for (String passengerName : passengerNames) {
////            BookingEntity booking = new BookingEntity(flight.getId(),passengerName);
////            flight.getBookings().add(booking);
////        }
////
////        // Update flight in the database
////        flightsDao.updateFlight(flight);
////
////        return true;
////    }
//
//
////    @Override
////    public String searchBookFlight(FlightsDto flightsDto) {
////        return null;
////    }
//
//    @Override
//    public List<FlightsEntity> searchFlights(String destination, String date, int numPeople) {
//        return flightsDao.searchFlights(destination, date, numPeople); // Delegate to DAO
//    }
//    @Override
//    public FlightsDto displayOnlineBoard(FlightsDto flightsDto) {
//        return null;
//    }
//
//
//    @Override
//    public FlightsEntity getFlightById(String flight_id) {
//        return flightsDao.getFlightById(flight_id);
//    }

}

