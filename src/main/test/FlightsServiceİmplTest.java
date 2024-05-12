//import net.bytebuddy.dynamic.DynamicType;
//import org.example.dao.FlightsDao;
//import org.example.service.FlightsService;
//import org.example.service.impl.FlightsServiceİmpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.junit.jupiter.api.Test;
//
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
//import static org.junit.jupiter.api.Assertions.*;
//import org.example.dao.FlightsDao;
//import org.example.entities.FlightsEntity;
//import org.example.model.dto.FlightsDto;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.testng.annotations.Optional;
//
//import java.util.*;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collection;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyList;
//import static org.mockito.Mockito.when;
//package az.edu.turing.service.impl;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import org.example.dao.FlightsDao;
//import org.example.entities.FlightsEntity;
//import org.example.model.dto.FlightsDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//class FlightsServiceİmplTest {
//    @Mock
//    private FlightsDao flightsDao;
//
//    private FlightsServiceİmpl flightsService;
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        flightsService = new FlightsServiceİmpl(flightsDao);
//    }
//
//    @org.junit.jupiter.api.Test
//    void createFlights() {
//        FlightsDto flightsDto = new FlightsDto(LocalDateTime.now(), 100, "Destination");
//
//        // Act
//        flightsService.createFlights(flightsDto);
//
//        // Assert
//        verify(flightsDao, times(1)).save(any());
//
//    }
//    @org.junit.jupiter.api.Test
//    void getAllFlight() {
//        FlightsEntity flightsEntity = new FlightsEntity(LocalDateTime.now(), 100, "Destination");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightsEntity)));
//
//        // Act
//        Collection<FlightsDto> result = flightsService.getAllFlight();
//
//        // Assert
//        assertFalse(result.isEmpty());
//        assertEquals(1, result.size());
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void getAllFlightByOrigin() {
//        // Arrange
//        String origin = "Origin";
//        FlightsEntity flightsEntity = new FlightsEntity(LocalDateTime.now(), 100, "Destination", origin);
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightsEntity)));
//
//        // Act
//        Collection<FlightsDto> result = flightsService.getAllFlightByOrigin(origin);
//
//        // Assert
//        assertFalse(result.isEmpty());
//        assertTrue(result.stream().allMatch(f -> f.getOrigin().equalsIgnoreCase(origin)));
//
//    }
//
//
//    @org.junit.jupiter.api.Test
//    void getAllFlightByDestination() {
//    }
//
//    @Test
//    void getOneFlightByFlightId_ReturnsFlightById() {
//        // Arrange
//        long id = 1;
//        LocalDateTime dateTime = LocalDateTime.now();
//        FlightsEntity flightEntity = new FlightsEntity( dateTime, 100, "Destination", "Origin");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightEntity)));
//
//        // Act
//        Optional<FlightsDto> result = flightsService.getOneFlightByFlightId(id);
//
//        // Assert
//        assertTrue(result.isPresent());
//        assertEquals(id, result.get().getId());
//    }
//    @Test
//    void getOneFlightByFlightId_ReturnsEmptyOptionalForNonexistentId() {
//        // Arrange
//        long id = 1;
//        LocalDateTime dateTime = LocalDateTime.now();
//        FlightsEntity flightEntity = new FlightsEntity(id + 1, dateTime, 100, "Destination", "Origin");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightEntity)));
//
//        // Act
//        Optional<FlightsDto> result = flightsService.getOneFlightByFlightId(id);
//
//        // Assert
//        assertTrue(result.isEmpty());
//    }
//
//
//    @Test
//    void getAllFlightByFlightId_ReturnsFlightsById() {
//        // Arrange
//        long id = 1;
//        LocalDateTime dateTime = LocalDateTime.now();
//        FlightsEntity flightEntity = new FlightsEntity(id, dateTime, 100, "Destination", "Origin");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightEntity)));
//
//        // Act
//        Collection<FlightsDto> result = flightsService.getAllFlightByFlightId(id);
//
//        // Assert
//        assertFalse(result.isEmpty());
//        assertTrue(result.stream().allMatch(f -> f.getId() == id));
//    }
//    @Test
//    void getAllFlightByFlightId_ReturnsEmptyCollectionForNonexistentId() {
//        // Arrange
//        long id = 1;
//        LocalDateTime dateTime = LocalDateTime.now();
//        FlightsEntity flightEntity = new FlightsEntity(id + 1, dateTime, 100, "Destination", "Origin");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flightEntity)));
//
//        // Act
//        Collection<FlightsDto> result = flightsService.getAllFlightByFlightId(id);
//
//        // Assert
//        assertTrue(result.isEmpty());
//    }
//
//    @org.junit.jupiter.api.Test
//    void flightsInNext24Hours() {
//        // Arrange
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime within24Hours = now.plusHours(12);
//        FlightsEntity flight1 = new FlightsEntity(within24Hours, 100, "Destination", "Origin1");
//        FlightsEntity flight2 = new FlightsEntity(now.plusHours(25), 100, "Destination", "Origin2");
//        when(flightsDao.getAll()).thenReturn(new ArrayList<>(List.of(flight1, flight2)));
//
//        // Act
//        Collection<FlightsDto> result = flightsService.flightsInNext24Hours("Origin1", now);
//
//        // Assert
//        assertFalse(result.isEmpty());
//        assertTrue(result.stream().allMatch(f -> f.getOrigin().equalsIgnoreCase("Origin1")));
//        assertTrue(result.stream().allMatch(f -> f.getDateTime().isAfter(now) && f.getDateTime().isBefore(within24Hours)));
//    }
//
//    }