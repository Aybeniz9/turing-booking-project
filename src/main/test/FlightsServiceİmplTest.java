
import org.example.dao.FlightsDao;
import org.example.entities.FlightsEntity;
import org.example.model.dto.FlightsDto;
import org.example.service.FlightsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.example.service.impl.FlightsServiceİmpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FlightsServiceİmplTest {
    private FlightsDao flightsDao;
    private FlightsService flightsService;

    @BeforeEach
    public void setUp() {
        flightsDao = Mockito.mock(FlightsDao.class);
        flightsService = new FlightsServiceİmpl(flightsDao);
    }


    @Test
    void createFlights() {
        FlightsDto flightsDto = new FlightsDto(1, LocalDateTime.now(), 5, "London","New York");

        flightsService.createFlights(flightsDto);

        Mockito.verify(flightsDao).save(Mockito.anyList());
    }

    @Test
    void getAllFlight() {
        List<FlightsEntity> flightsEntities = Arrays.asList(
                new FlightsEntity(LocalDateTime.now(), 100, "New York", "London"),
                new FlightsEntity(LocalDateTime.now().plusHours(2), 150, "Paris", "Berlin")
        );
        when(flightsDao.getAll()).thenReturn(flightsEntities);

        Collection<FlightsDto> flightsDtos = flightsService.getAllFlight();

        assertEquals(2, flightsDtos.size());
    }

    @Test
    void getAllFlightByOrigin() {
        String origin = "New York";
        List<FlightsEntity> flightsEntities = Arrays.asList(
                new FlightsEntity(LocalDateTime.now(), 100, "New York", "London"),
                new FlightsEntity(LocalDateTime.now().plusHours(2), 150, "Paris", "Berlin")
        );
        when(flightsDao.getAll()).thenReturn(flightsEntities);

        Collection<FlightsDto> flightsDtos = flightsService.getAllFlightByOrigin(origin);

        assertEquals(1, flightsDtos.size());
        assertEquals(origin, flightsDtos.iterator().next().getOrigin());
    }

    @Test
    public void testGetAllFlightByDestination() {
        String destination = "London";
        List<FlightsEntity> flightsEntities = Arrays.asList(
                new FlightsEntity(LocalDateTime.now(), 100, "New York", "London"),
                new FlightsEntity(LocalDateTime.now().plusHours(2), 150, "Paris", "Berlin")
        );
        when(flightsDao.getAll()).thenReturn(flightsEntities);

        Collection<FlightsDto> flightsDtos = flightsService.getAllFlightByDestination(destination);

        assertEquals(1, flightsDtos.size());
        assertEquals(destination, flightsDtos.iterator().next().getDestination());
    }

    @Test
    public void testGetOneFlightByFlightId() {
        long id = 1;
        FlightsEntity flightsEntity = new FlightsEntity(LocalDateTime.now(), 100, "New York", "London");
        when(flightsDao.getAll()).thenReturn(Arrays.asList(flightsEntity));

        Optional<FlightsDto> flightsDtoOptional = flightsService.getOneFlightByFlightId(id);

       // assertEquals(id, flightsDtoOptional.get().getId());
    }

    @Test
    public void testGetAllFlightByFlightId() {
        long id = 1;
        FlightsEntity flightsEntity = new FlightsEntity(LocalDateTime.now(), 100, "New York", "London");
        when(flightsDao.getAll()).thenReturn(Arrays.asList(flightsEntity));

        Collection<FlightsDto> flightsDtos = flightsService.getAllFlightByFlightId(id);

        assertEquals(1, flightsDtos.size());
        assertEquals(id, flightsDtos.iterator().next().getId());
    }

    @Test
    public void testFlightsInNext24Hours() {
        String origin = "New York";
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime next24Hours = now.plusHours(24);
        FlightsEntity flightInNext24Hours = new FlightsEntity(now.plusHours(12), 100, "New York", "London");
        FlightsEntity flightNotInNext24Hours = new FlightsEntity(now.plusDays(2), 150, "Paris", "Berlin");
        List<FlightsEntity> flightsEntities = Arrays.asList(flightInNext24Hours, flightNotInNext24Hours);
        when(flightsDao.getAll()).thenReturn(flightsEntities);

        Collection<FlightsDto> flightsInNext24Hours = flightsService.flightsInNext24Hours(origin, now);

        assertEquals(1, flightsInNext24Hours.size());
        assertEquals(flightInNext24Hours.getDateTime(), flightsInNext24Hours.iterator().next().getDateTime());
    }
}


















