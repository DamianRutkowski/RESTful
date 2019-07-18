package com.guns.spring.service.encyclopedia;

import com.guns.model.admin.encyclopedia.WeaponComment;
import com.guns.spring.repository.encyclopedia.WeaponCommentDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 26-May-16.
 */

@Service
public class WeaponCommentService extends AbstractService<WeaponComment> {

    private static final long serialVersionUID = -8712612788753228290L;

    @Autowired
    public WeaponCommentService(WeaponCommentDAO weaponCommentDAO) {
        this.abstractDAO = weaponCommentDAO;
    }

    private WeaponCommentDAO getDAO() {
        return (WeaponCommentDAO) this.abstractDAO;
    }
}
