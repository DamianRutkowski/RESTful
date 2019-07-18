package com.guns.spring.service.encyclopedia;

import com.guns.model.admin.encyclopedia.Weapon;
import com.guns.spring.repository.encyclopedia.WeaponDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */

@Service
public class WeaponService extends AbstractService<Weapon> {

    private static final long serialVersionUID = -6126600284714825937L;

    @Autowired
    public WeaponService(WeaponDAO weaponDAO) {
        this.abstractDAO = weaponDAO;
    }

    private WeaponDAO getDAO() {
        return (WeaponDAO)this.abstractDAO;
    }

    public Weapon findByTagName(String tagName) {
        return getDAO().findByTagName(tagName);
    }
}
