package org.example.dao;

import org.example.entities.FlightsEntity;

import java.util.*;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {

    void save(List<T> t);

    void delete(int id);

    Collection<T> getAllFLights();

    Collection<T> getById();

    Collection<T> getAll();

    Optional<T> findOneBy(Predicate<T> predicate);

    Collection<T> findAllBy(Predicate<T> predicate);

    FlightsEntity getFlightById(String Id);
}