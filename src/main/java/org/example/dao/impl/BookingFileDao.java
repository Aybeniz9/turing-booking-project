package org.example.dao.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dao.BookingDao;

public class BookingFileDao  extends BookingDao {

    private static final String RESOURCE_PATH = "src/main/java/org/example/resource";
    private static final String BOOKINGS_FILE_PATH = RESOURCE_PATH.concat("bookings.txt");
    private final ObjectMapper objectMapper;

    public BookingFileDao(ObjectMapper objectMapper) {

        this.objectMapper = objectMapper;
    }

}
