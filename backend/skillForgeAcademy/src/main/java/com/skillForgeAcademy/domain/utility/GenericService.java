package com.skillForgeAcademy.domain.utility;

import java.util.List;

public interface GenericService<T, S> {

    T create (T t);
    T find (S id);

    List findAll();

    T delete(S id);
}
