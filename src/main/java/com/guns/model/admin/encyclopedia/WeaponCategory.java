package com.guns.model.admin.encyclopedia;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.admin.encyclopedia.Weapon;
import com.guns.model.common.PersistentEntityWithTagName;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian Rutkowski on 2015-10-10.
 */

@Entity
public class WeaponCategory extends PersistentEntityWithTagName {

    private static final long serialVersionUID = 1816336633523434115L;

    private String name;

    @OneToMany(targetEntity = Weapon.class, fetch = FetchType.EAGER, mappedBy = "weaponCategory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Weapon> weapons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<Weapon> weapons) {
        this.weapons = weapons;
    }
}
