package com.guns.spring.service.user;

import com.guns.model.admin.user.Role;
import com.guns.spring.repository.user.RoleDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 21-Nov-15.
 */

@Service
public class RoleService extends AbstractService<Role> {

    private static final long serialVersionUID = -4317416240810344245L;

    public Role findByName(String name) {
        return getDAO().findByName(name);
    }

    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.abstractDAO = roleDAO;
    }

    private RoleDAO getDAO() {
        return (RoleDAO) this.abstractDAO;
    }
}
