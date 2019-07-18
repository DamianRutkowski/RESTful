package com.guns.spring.service.user;

import com.guns.model.admin.user.User;
import com.guns.spring.repository.user.UserDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 21-Nov-15.
 */

@Service
public class UserService extends AbstractService<User> {

    private static final long serialVersionUID = -1193507757129519344L;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.abstractDAO = userDAO;
    }

    private UserDAO getDAO() {
        return (UserDAO) this.abstractDAO;
    }

    public User findByUsername(String username) {
        return getDAO().findByUsername(username);
    }

    public User findByActivationToken(String token) {
        return getDAO().findByActivationToken(token);
    }

    public List<User> findAllEmployees() {
        return getDAO().findAllEmployees();
    }

    public List<User> findAllAdmins() {
        return getDAO().findAllAdmins();
    }

    public List<User> findAllUsers() {
        return getDAO().findAllUsers();
    }
}
