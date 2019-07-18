package com.guns.spring.repository.user;

import com.guns.model.admin.user.User;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damian on 21-Nov-15.
 */

public interface UserDAO extends AbstractDAO<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User findByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.activationToken = :token")
    public User findByActivationToken(@Param("token") String token);

    @Query("SELECT u FROM User u WHERE (select count(r) from u.roles r where r.name = 'EMPLOYEE') = 1")
    public List<User> findAllEmployees();

    @Query("SELECT u FROM User u WHERE (select count(r) from u.roles r where r.name = 'ADMIN') = 1")
    public List<User> findAllAdmins();

    @Query("SELECT u FROM User u WHERE (select count(r) from u.roles r where r.name = 'USER') = 1")
    public List<User> findAllUsers();
}
