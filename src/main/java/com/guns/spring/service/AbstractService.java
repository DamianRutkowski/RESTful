package com.guns.spring.service;

import com.guns.spring.repository.AbstractDAO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */


public abstract class AbstractService<T> implements Serializable {

    private static final long serialVersionUID = 8020644814498019600L;

    protected AbstractDAO<T, Long> abstractDAO;

    public List<T> listAll() {
        return (List<T>) abstractDAO.findAll();
    }

    public T create(T entity) {
        return abstractDAO.save(entity);
    }

    public void delete(T entity) {
        abstractDAO.delete(entity);
    }

    public void deleteList(List<T> entities) {
        abstractDAO.delete(entities);
    }

    public T findById(Long id) {
        return abstractDAO.findById(id);
    }
}

