package org.example.dao.impl;

import org.example.dao.DAO;
import org.example.entities.FlightsEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FlightDb implements DAO<FlightsEntity>,FlightDaoInterfeace {

    Connection connection = new DbConnection().getConnection();

    @Override
    public void save(List<FlightsEntity> flightsEntities) {
        final String flightsave = "INSERT INTO flights(departure_time,free_seats,destination,origin) VALUES (?,?,?,?)";
        try (PreparedStatement statementflight = connection.prepareStatement(flightsave)) {
            for (FlightsEntity flightsEntity : flightsEntities) {
                statementflight.setTimestamp(1, Timestamp.valueOf(flightsEntity.getDateTime()));
                statementflight.setInt(2, flightsEntity.getFreeSpaces());
                statementflight.setString(3, flightsEntity.getDestination());
                statementflight.setString(4, flightsEntity.getOrigin());
                statementflight.addBatch();
            }
            statementflight.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long passengerId) {
        final String deleteflights = "DELETE FROM flights WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteflights)) {
            statement.setLong(1, passengerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Collection<FlightsEntity> getAll() {
        final String sql = "SELECT * FROM flights";
        List<FlightsEntity> flightEntities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightsEntity flightEntity = new FlightsEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("free_seats"),
                        resultSet.getTimestamp("departure_time").toLocalDateTime(),
                        resultSet.getString("origin"),
                        resultSet.getString("destination"));
                flightEntities.add(flightEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flightEntities;
    }

    @Override
    public Optional<FlightsEntity> findOneBy(long id) {
        final String sql = "SELECT * FROM flights WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightsEntity flightEntity = new FlightsEntity();
                flightEntity.setId(resultSet.getLong("id"));
                flightEntity.setDateTime(resultSet.getTimestamp("departure_time").toLocalDateTime());
                flightEntity.setFreeSpaces(resultSet.getInt("free_seats"));
                flightEntity.setDestination(resultSet.getString("destination"));
                flightEntity.setOrigin(resultSet.getString("origin"));
                return Optional.of(flightEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Collection<FlightsEntity>> findAllBy(Predicate<FlightsEntity> predicate) {
        final String getAllBySql = "SELECT * FROM flights";
        Collection<FlightsEntity> matchingFlights = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(getAllBySql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FlightsEntity flightEntity = new FlightsEntity(
                        resultSet.getLong("id"),
                        resultSet.getInt("free_spaces"),
                        resultSet.getTimestamp("departure_time").toLocalDateTime(),
                        resultSet.getString("destination"),
                        resultSet.getString("origin"));
                if (predicate.test(flightEntity)) {
                    matchingFlights.add(flightEntity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingFlights.isEmpty() ? Optional.empty() : Optional.of(matchingFlights);
    }

    @Override
    public void update(long passengerId, int seats) {
        final String sqlSeats = "SELECT free_seats FROM flights WHERE id = ?";
        final String sqlUpdate = "UPDATE flights SET free_seats = ? WHERE id = ? ";
        try {
            int currentSeats;
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSeats)) {
                preparedStatement.setLong(1, passengerId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    currentSeats = resultSet.getInt("free_seats");
                    int currentSeatsUpdated = currentSeats + seats;
                    try (PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate)) {
                        updateStatement.setInt(1, currentSeatsUpdated);
                        updateStatement.setLong(2, passengerId);
                        updateStatement.executeUpdate();
                    }
                } else {
                    throw new SQLException("Flight " + passengerId + " not found");
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connection.setAutoCommit(true);
                            connection.close();
                        } catch (SQLException closeException) {
                            closeException.printStackTrace();
                        }
                    }
                }
            }
        }

    }


}

