package com.guns.spring.repository.user;

import com.guns.model.admin.user.Role;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 21-Nov-15.
 */

public interface RoleDAO extends AbstractDAO<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    public Role findByName(@Param("name") String name);
}
