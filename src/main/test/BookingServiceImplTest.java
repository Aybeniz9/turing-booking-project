import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;
import org.example.model.dto.BookingDto;
import org.example.service.BookingService;
import org.example.service.impl.BookingServiceİmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookingServiceImplTest {

    private BookingDao bookingDao;
    private BookingService bookingService;

    @BeforeEach
    public void setUp() {
        bookingDao = Mockito.mock(BookingDao.class);
        bookingService = new BookingServiceİmpl(bookingDao);
    }

    @Test
    public void testCreateBooking() {
        BookingDto bookingDto = new BookingDto(1, 2, "Ali");

        bookingService.createBooking(bookingDto);

        Mockito.verify(bookingDao).save(Mockito.anyList());
    }

    @Test
    public void testCancelBooking() {
        long passengerId = 123;

        bookingService.cancelBooking(passengerId);

        Mockito.verify(bookingDao).delete(passengerId);
    }

    @Test
    public void testGetAllBookings() {
        List<BookingEntity> bookingEntities = Arrays.asList(
                new BookingEntity(1, 2,"Ali"),
                new BookingEntity(2, 3, "Farid")
        );
        when(bookingDao.getAll()).thenReturn(bookingEntities);

        Collection<BookingDto> bookings = bookingService.getAllBookings();

        assertEquals(2, bookings.size());
    }

    @Test
    public void testGetMyFlights() {
        long flightId = 101;
        String passengerName = "John Doe";
        List<BookingEntity> bookingEntities = Arrays.asList(
                new BookingEntity(1, 2, "Ali"),
                new BookingEntity(2, 3, "Farid")
        );
        when(bookingDao.findAllBy(Mockito.any())).thenReturn(Optional.of(bookingEntities));

        Collection<BookingDto> myFlights = bookingService.getMyFlights(flightId, passengerName);

        assertEquals(1, myFlights.size());
    }

    @Test
    public void testFindBookingByOne() {
        long passengerId = 123;
        BookingEntity bookingEntity = new BookingEntity(passengerId, 2, "Ali");
        when(bookingDao.getAll()).thenReturn(Arrays.asList(bookingEntity));

        BookingDto bookingDto = bookingService.findBookingByOne(passengerId);

        assertEquals(bookingEntity.getPassengerId(), bookingDto.getId());
        assertEquals(bookingEntity.getFlightId(), bookingDto.getFlightId());
        assertEquals(bookingEntity.getPassengerName(), bookingDto.getPassengerName());
    }
}