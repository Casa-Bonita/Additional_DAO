package DAO;

import java.util.*;

public interface Dao <T> {
    // create/save
    void save (T t);

    // read
    List<T> getAll();

    // read by id
    T getById(int id);

    //update
    void update(T oldT, T newT);

    // delete
    void remove (T t);

}