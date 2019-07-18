package com.guns.spring.repository.encyclopedia;

import com.guns.model.admin.encyclopedia.WeaponCategory;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian Rutkowski on 2015-10-10.
 */
public interface WeaponCategoryDAO extends AbstractDAO<WeaponCategory, Long> {

    @Query("SELECT c FROM WeaponCategory c WHERE c.tagName = (:tagName)")
    WeaponCategory findByTagName(@Param("tagName") String tagName);
}
