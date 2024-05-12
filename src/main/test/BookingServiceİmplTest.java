import org.example.dao.BookingDao;
import org.example.model.dto.BookingDto;
import org.example.service.impl.BookingServiceİmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class BookingServiceİmplTest {
    private BookingDao bookingDao;
    private BookingServiceİmpl bookingService;

    @BeforeEach
    void setUp() {
        bookingDao = mock(BookingDao.class);
        bookingService = new BookingServiceİmpl(bookingDao);
    }

    @Test
    void createBooking() {
        // Arrange
        BookingDto bookingDto = new BookingDto(1, "John Doe");

        // Act
        bookingService.createBooking(bookingDto);

        // Assert
        verify(bookingDao, times(1)).save(anyList());
    }

    @Test
    void cancelBooking() {
    }

    @Test
    void getAllBookings() {
    }

    @Test
    void getMyFlights() {
    }

    @Test
    void findBookingByOne() {
    }
}