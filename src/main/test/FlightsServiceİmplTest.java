import net.bytebuddy.dynamic.DynamicType;
import org.example.dao.FlightsDao;
import org.example.service.FlightsService;
import org.example.service.impl.FlightsServiceİmpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import org.example.dao.FlightsDao;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Optional;

import java.util.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
package az.edu.turing.service.impl;

import az.edu.turing.dao.FlightsDao;
import az.edu.turing.entity.FlightsEntity;
import az.edu.turing.model.FlightsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FlightsServiceİmplTest {
    @Mock
    private FlightsDao flightsDao;

    private FlightsServiceİmpl flightsService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        flightsService = new FlightsServiceİmpl(flightsDao);
    }

    @org.junit.jupiter.api.Test
    void createFlights() {
        FlightsDto flightsDto = new FlightsDto(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination", "Location", 100);

        // Execute the method
        flightsService.createFlights(flightsDto);

        // Verify the interaction with the DAO
        verify(flightsDao, times(1)).getAll();
        verify(flightsDao, times(1)).save(anyCollection());
    }
    @org.junit.jupiter.api.Test
    void getAllFlight() {
            // Mock FlightsDao
            FlightsDao flightsDao = Mockito.mock(FlightsDao.class);

            // Create some test data
            FlightsDto flight1 = new FlightsDto(1, LocalDateTime.now(), 100, "Destination1", "Origin1");
            FlightsDto flight2 = new FlightsDto(2, LocalDateTime.now(), 150, "Destination2", "Origin2");
            FlightsDto flight3 = new FlightsDto(3, LocalDateTime.now(), 200, "Destination3", "Origin3");

            // Mock behavior of flightsDao.getAll()
            when(flightsDao.getAll()).thenReturn(Arrays.asList(
                    new FlightsEntity(flight1.getDateTime(), flight1.getFreeSpaces(), flight1.getDestination(), flight1.getOrigin()),
                    new FlightsEntity(flight2.getDateTime(), flight2.getFreeSpaces(), flight2.getDestination(), flight2.getOrigin()),
                    new FlightsEntity(flight3.getDateTime(), flight3.getFreeSpaces(), flight3.getDestination(), flight3.getOrigin())
            ));

            // Create FlightsServiceImpl instance with mocked FlightsDao
            FlightsServiceİmpl flightsService = new FlightsServiceİmpl(flightsDao);

            // Call the method to be tested
            Collection<FlightsDto> allFlights = flightsService.getAllFlight();

            // Assertions
            assertEquals(3, allFlights.size()); // Expecting 3 flights
        }

    @org.junit.jupiter.api.Test
    void getAllFlightByOrigin() {
        FlightsDao flightsDao = Mockito.mock(FlightsDao.class);

        // Create some test data
        FlightsDto flight1 = new FlightsDto(1, LocalDateTime.now(), 100, "Destination1", "Origin1");
        FlightsDto flight2 = new FlightsDto(2, LocalDateTime.now(), 150, "Destination2", "Origin2");
        FlightsDto flight3 = new FlightsDto(3, LocalDateTime.now(), 200, "Destination3", "Origin1");

        // Mock behavior of flightsDao.getAll()
        when(flightsDao.getAll()).thenReturn(Arrays.asList(
                new FlightsEntity(flight1.getDateTime(), flight1.getFreeSpaces(), flight1.getDestination(), flight1.getOrigin()),
                new FlightsEntity(flight2.getDateTime(), flight2.getFreeSpaces(), flight2.getDestination(), flight2.getOrigin()),
                new FlightsEntity(flight3.getDateTime(), flight3.getFreeSpaces(), flight3.getDestination(), flight3.getOrigin())
        ));

        // Create FlightsServiceImpl instance with mocked FlightsDao
        FlightsServiceİmpl flightsService = new FlightsServiceİmpl(flightsDao);

        // Call the method to be tested
        Collection<FlightsDto> flightsByOrigin = flightsService.getAllFlightByOrigin("Origin1");

        // Assertions
        assertEquals(2, flightsByOrigin.size());
        assertTrue(flightsByOrigin.stream().allMatch(flight -> flight.getOrigin().equalsIgnoreCase("Origin1")));
    }

    // Add more tests for other methods similarly


    @org.junit.jupiter.api.Test
    void getAllFlightByDestination() {
    }

    @Test
    void getOneFlightByFlightId() {
        FlightsDao flightsDao = Mockito.mock(FlightsDao.class);

        // Create some test data
        FlightsDto flight1 = new FlightsDto(1, LocalDateTime.now(), 100, "Destination1", "Origin1");
        FlightsDto flight2 = new FlightsDto(2, LocalDateTime.now(), 150, "Destination2", "Origin2");
        FlightsDto flight3 = new FlightsDto(3, LocalDateTime.now(), 200, "Destination3", "Origin3");

        // Mock behavior of flightsDao.getAll()
        when(flightsDao.getAll()).thenReturn(Arrays.asList(
                new FlightsEntity(flight1.getDateTime(), flight1.getFreeSpaces(), flight1.getDestination(), flight1.getOrigin()),
                new FlightsEntity(flight2.getDateTime(), flight2.getFreeSpaces(), flight2.getDestination(), flight2.getOrigin()),
                new FlightsEntity(flight3.getDateTime(), flight3.getFreeSpaces(), flight3.getDestination(), flight3.getOrigin())
        ));

        // Create FlightsServiceImpl instance with mocked FlightsDao
        FlightsServiceİmpl flightsService = new FlightsServiceİmpl(flightsDao);

        // Call the method to be tested
        Optional<FlightsDto> flightById = flightsService.getOneFlightByFlightId(2);

        // Assertions
        assertTrue(flightById.isPresent()); // Expecting a non-empty Optional
        assertEquals(2, flightById.get().getId()); // Expecting flight with ID 2
    }


    @org.junit.jupiter.api.Test
    void getAllFlightByFlightId() {
    }

    @org.junit.jupiter.api.Test
    void flightsInNext24Hours() {
        FlightsDao flightsDao = Mockito.mock(FlightsDao.class);

        // Create some test data
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextHour = now.plusHours(1);
        LocalDateTime next24Hours = now.plusHours(24);

        FlightsDto flight1 = new FlightsDto(1, nextHour, 100, "Destination1", "Origin1");
        FlightsDto flight2 = new FlightsDto(2, next24Hours, 150, "Destination2", "Origin2");
        FlightsDto flight3 = new FlightsDto(3, now.minusHours(1), 200, "Destination3", "Origin3");

        // Mock behavior of flightsDao.getAll()
        when(flightsDao.getAll()).thenReturn(Arrays.asList(
                new FlightsEntity(flight1.getDateTime(), flight1.getFreeSpaces(), flight1.getDestination(), flight1.getOrigin()),
                new FlightsEntity(flight2.getDateTime(), flight2.getFreeSpaces(), flight2.getDestination(), flight2.getOrigin()),
                new FlightsEntity(flight3.getDateTime(), flight3.getFreeSpaces(), flight3.getDestination(), flight3.getOrigin())
        ));

        // Create FlightsServiceImpl instance with mocked FlightsDao
        FlightsServiceİmpl flightsService = new FlightsServiceİmpl(flightsDao);

        // Call the method to be tested
        Collection<FlightsDto> flightsInNext24Hours = flightsService.flightsInNext24Hours("Origin1", now);

        // Assertions
        assertEquals(1, flightsInNext24Hours.size()); // Expecting 1 flight in the next 24 hours
        assertTrue(flightsInNext24Hours.stream().allMatch(flight -> flight.getOrigin().equalsIgnoreCase("Origin1"))); // Expecting flight with origin "Origin1"
        assertTrue(flightsInNext24Hours.stream().allMatch(flight -> flight.getDateTime().isAfter(now) && flight.getDateTime().isBefore(next24Hours))); // Expecting flight within next 24 hours
    }
    }