package com.guns.spring.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */

public interface AbstractDAO<T, ID extends Serializable> extends
        CrudRepository<T, ID> {

    T findById(long id);
}

