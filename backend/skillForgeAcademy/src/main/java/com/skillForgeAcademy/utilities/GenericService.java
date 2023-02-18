package com.skillForgeAcademy.utilities;

public interface GenericService<T, S> {

    T create (T t);
    T find (S id);

    Iterable<T> findAll();

    T delete(S id) throws Exception;
}
