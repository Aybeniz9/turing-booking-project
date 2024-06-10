package org.example.dao.impl;

import org.example.dao.BookingDao;
import org.example.dao.DAO;
import org.example.entities.BookingEntity;

import java.sql.*;
import java.util.*;
import java.util.function.Predicate;

public class BookingDb extends BookingDao {

    Connection connection = new DbConnection().getConnection();

    @Override
    public void save(List<BookingEntity> bookingEntities) {
        final String insertBookings = "INSERT INTO bookings (flight_id) VALUES (?)";
        final String insertPassengers = "INSERT INTO passengers (full_name) VALUES (?)";
        final String insertBookingPassenger = "INSERT INTO booking_passengers (booking_id, passenger_id) VALUES (?, ?)";

        try (
                PreparedStatement bookingPs = connection.prepareStatement(insertBookings, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement passengerPs = connection.prepareStatement(insertPassengers, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement bookingPassengerPs = connection.prepareStatement(insertBookingPassenger)
        ) {
            connection.setAutoCommit(false);

            for (BookingEntity bookingEntity : bookingEntities) {
                bookingPs.setLong(1, bookingEntity.getFlightId());
                bookingPs.executeUpdate();
                ResultSet bookingRs = bookingPs.getGeneratedKeys();
                if (bookingRs.next()) {
                    long bookingId = bookingRs.getLong(1);
                    String[] passengerNamesArray = bookingEntity.getPassengerName().split(",");
                    for (String passengerName : passengerNamesArray) {
                        passengerPs.setString(1, passengerName.trim());
                        passengerPs.executeUpdate();
                        ResultSet passengerRs = passengerPs.getGeneratedKeys();
                        if (passengerRs.next()) {
                            long passengerId = passengerRs.getLong(1);
                            bookingPassengerPs.setLong(1, bookingId);
                            bookingPassengerPs.setLong(2, passengerId);
                            bookingPassengerPs.executeUpdate();
                        }
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void delete(long passengerId) {
        final String deleteBookingPassengerSql = "DELETE FROM booking_passenger WHERE passenger_id = ?";
        final String deleteBookingSql = "DELETE FROM bookings WHERE id = ?";
        try {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(deleteBookingPassengerSql)) {
                statement.setLong(1, passengerId);
                statement.executeUpdate();
            }
            try (PreparedStatement statement = connection.prepareStatement(deleteBookingSql)) {
                statement.setLong(1, passengerId);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException autoCommitEx) {
                autoCommitEx.printStackTrace();
            }
        }
    }

    public List<BookingEntity> getAll() {
        Map<Long, BookingEntity> bookingMap = new HashMap<>();
        final String sql = "SELECT b.id AS booking_id, b.flight_id, p.full_name " +
                "FROM bookings b " +
                "JOIN booking_passengers bp ON b.id = bp.booking_id " +
                "JOIN passengers p ON bp.passenger_id = p.id";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                long bookingId = rs.getLong("booking_id");
                long flightId = rs.getLong("flight_id");
                String passengerName = rs.getString("full_name");

                bookingMap.computeIfAbsent(bookingId, id -> {
                    BookingEntity newBooking = new BookingEntity();
                    newBooking.setBookingID(id);
                    newBooking.setFlightId(flightId);
                    newBooking.setPassengerName(passengerName);
                    return newBooking;
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(bookingMap.values());
    }

    @Override
    public Optional<BookingEntity> findOneBy(long id) {
        final String sql = "SELECT bookings.id, bookings.flight_id,passengers.full_name" +
                "FROM bookings" +
                "INNER JOIN booking_passengers ON bookings.id = booking_passengers.booking_id" +
                "INNER JOIN passenger ON booking_passengers.passenger_id = passenger.id" +
                "WHERE bookings.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    long bookingId = resultSet.getInt("id");
                    long flightId = resultSet.getInt("flight_id");
                    String passenger_name = resultSet.getString("full_name");

                    BookingEntity booking = new BookingEntity();
                    booking.setBookingID(bookingId);
                    booking.setFlightId(flightId);
                    booking.setPassengerName(passenger_name);
                    return Optional.of(booking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Collection<BookingEntity>> findAllBy(Predicate<BookingEntity> predicate) {
        List<BookingEntity> bookingEntities = new ArrayList<>();
        final String sql = "SELECT bookings.id, bookings.flight_id,passengers.full_name" +
                "FROM bookings" +
                "INNER JOIN booking_passenger ON bookings.id=booking_passenger.booking_id" +
                "INNER JOIN passengers ON booking_passengers.passenger_id =passengers.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long bookingId = resultSet.getLong("id");
                long flightId = resultSet.getLong("flight_id");
                String passengername = resultSet.getString("full_name");
                BookingEntity booking = new BookingEntity();
                booking.setBookingID(bookingId);
                booking.setFlightId(flightId);
                booking.setPassengerName(passengername);
                bookingEntities.add(booking);
                if (predicate.test(booking)) {
                    bookingEntities.add(booking);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(bookingEntities);
    }
}

