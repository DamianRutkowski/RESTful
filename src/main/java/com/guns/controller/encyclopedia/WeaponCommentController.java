package com.guns.controller.encyclopedia;

import com.guns.model.admin.encyclopedia.WeaponComment;
import com.guns.spring.service.encyclopedia.WeaponCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damian on 26-May-16.
 */

@RestController
@RequestMapping("api/weapon-comments")
public class WeaponCommentController {

    @Autowired
    private WeaponCommentService weaponCommentService;

    @RequestMapping(method = RequestMethod.POST)
    public WeaponComment create(@RequestBody @Validated WeaponComment weaponComment) {
        return weaponCommentService.create(weaponComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public WeaponComment update(@RequestBody @Validated WeaponComment weaponComment) {
        return weaponCommentService.create(weaponComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        WeaponComment weaponComment = weaponCommentService.findById(id);

        weaponCommentService.delete(weaponComment);
    }

    public WeaponCommentService getWeaponCommentService() {
        return weaponCommentService;
    }

    public void setWeaponCommentService(WeaponCommentService weaponCommentService) {
        this.weaponCommentService = weaponCommentService;
    }
}
