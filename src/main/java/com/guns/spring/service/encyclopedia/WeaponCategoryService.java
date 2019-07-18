package com.guns.spring.service.encyclopedia;

import com.guns.model.admin.encyclopedia.WeaponCategory;
import com.guns.spring.repository.encyclopedia.WeaponCategoryDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian Rutkowski on 2015-10-10.
 */

@Service
public class WeaponCategoryService extends AbstractService<WeaponCategory> {

    private static final long serialVersionUID = 4593874455778251070L;

    @Autowired
    public WeaponCategoryService(WeaponCategoryDAO weaponCategoryDAO) {
        this.abstractDAO = weaponCategoryDAO;
    }

    private WeaponCategoryDAO getDAO() {
        return (WeaponCategoryDAO)this.abstractDAO;
    }

    public WeaponCategory findByTagName(String tagName) {
        return getDAO().findByTagName(tagName);
    }
}
