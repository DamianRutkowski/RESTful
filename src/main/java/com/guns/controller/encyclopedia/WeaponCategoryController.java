package com.guns.controller.encyclopedia;

import com.guns.model.admin.encyclopedia.Weapon;
import com.guns.model.admin.encyclopedia.WeaponCategory;
import com.guns.spring.service.encyclopedia.WeaponCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian Rutkowski on 2015-10-12.
 */


@RestController
@RequestMapping(value = "api/weapon-categories")
public class WeaponCategoryController {

    @Autowired
    private WeaponCategoryService weaponCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<WeaponCategory> getAll() {
        return weaponCategoryService.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WeaponCategory getById(@PathVariable Long id) {
        return weaponCategoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public WeaponCategory create(@RequestBody @Validated WeaponCategory weaponCategory) {
        return weaponCategoryService.create(weaponCategory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public WeaponCategory update(@PathVariable Long id, @RequestBody @Validated WeaponCategory weaponCategory) {
        return weaponCategoryService.create(weaponCategory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        WeaponCategory weaponCategory = weaponCategoryService.findById(id);

        weaponCategoryService.delete(weaponCategory);
    }

    public WeaponCategoryService getWeaponCategoryService() {
        return weaponCategoryService;
    }

    public void setWeaponCategoryService(WeaponCategoryService weaponCategoryService) {
        this.weaponCategoryService = weaponCategoryService;
    }


}
