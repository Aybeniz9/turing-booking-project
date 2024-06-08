package org.example.dao;

import java.sql.SQLException;
import java.util.*;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {

    void save(List<T> t);

    void delete(long passengerId);

    Collection<T> getAll();

    Optional<T> findOneBy(long id);

    Optional<Collection<T>> findAllBy(Predicate<T> predicate);


}