package org.example.dao;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO <T>{
    T save(T t);

  Collection<T> getAll();

  Optional<T> findOneBy(Predicate<T> predicate);

    Collection<T> findAllBy(Predicate<T> predicate);

}
