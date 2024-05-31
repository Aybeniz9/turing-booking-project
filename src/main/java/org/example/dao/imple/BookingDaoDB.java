package org.example.dao.imple;

import org.example.dao.BookingDao;
import org.example.entities.BookingEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookingDaoDB extends BookingDao implements JdbcConnect {
    BookingEntity booking = new BookingEntity();


    @Override
    public void save(List<BookingEntity> t) {
        String sql = "INSERT INTO bookings (id, passengerName, flightNumber, date) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                statement.setLong(1, booking.getPassengerId());
                statement.setLong(2, booking.getFlightId());
                statement.setString(3, booking.getPassengerName());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(long passengerId) {
        String sql ="DELETE FROM bookings WHERE id =?";

        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            statement.setLong(1, passengerId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Collection<BookingEntity> getAll() {
        String sql = "select * from booking";
        List<BookingEntity> bookings = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                booking.setPassengerId(resultSet.getLong("id"));
                booking.setFlightId(resultSet.getLong("flight_id"));
                booking.setPassengerName(resultSet.getString("passenger_name"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Optional<Collection<BookingEntity>> findAllBy(Predicate<BookingEntity> predicate) {
        return Optional.empty();
    }

    @Override
    public Connection getConnection() {
        return JdbcConnect.super.getConnection();
    }
}
