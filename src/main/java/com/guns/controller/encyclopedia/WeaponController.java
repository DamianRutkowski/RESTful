package com.guns.controller.encyclopedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guns.model.admin.encyclopedia.Weapon;
import com.guns.spring.service.encyclopedia.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian Rutkowski on 2015-09-27.
 */

@RestController
@RequestMapping(value = "api/weapons")
public class WeaponController {

    private ObjectMapper objectMapper;

    @Autowired
    private WeaponService weaponService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Weapon> getAll() {
        return weaponService.listAll();
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
    public Weapon getByTagName(@PathVariable String tagName) {
        return weaponService.findByTagName(tagName);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.POST)
    public Weapon create(@PathVariable String tagName, @RequestBody @Validated Weapon weapon) {
        return weaponService.create(weapon);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.PUT)
    public Weapon update(@PathVariable String tagName, @RequestBody @Validated Weapon weapon) {
        return weaponService.create(weapon);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String tagName) {
        Weapon weapon = weaponService.findByTagName(tagName);

        weaponService.delete(weapon);
    }

    public WeaponService getWeaponService() {
        return weaponService;
    }

    public void setWeaponService(WeaponService weaponService) {
        this.weaponService = weaponService;
    }
}
