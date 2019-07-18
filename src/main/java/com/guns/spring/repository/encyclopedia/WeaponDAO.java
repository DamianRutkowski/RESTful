package com.guns.spring.repository.encyclopedia;

import com.guns.model.admin.encyclopedia.Weapon;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */
public interface WeaponDAO extends AbstractDAO<Weapon, Long> {

    @Query("SELECT w FROM Weapon w WHERE w.tagName = (:tagName)")
    Weapon findByTagName(@Param("tagName") String tagName);
}
