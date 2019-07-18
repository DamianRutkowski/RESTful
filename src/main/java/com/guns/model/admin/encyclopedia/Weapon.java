package com.guns.model.admin.encyclopedia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.common.PersistentEntityWithTagName;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */

@Entity
public class Weapon extends PersistentEntityWithTagName {

    private static final long serialVersionUID = -1666719206934623861L;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @ManyToOne(targetEntity = WeaponCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private WeaponCategory weaponCategory;

    @OneToMany(targetEntity = WeaponComment.class, fetch = FetchType.EAGER, mappedBy = "weapon")
    private Set<WeaponComment> weaponComments;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WeaponCategory getWeaponCategory() {
        return weaponCategory;
    }

    public void setWeaponCategory(WeaponCategory weaponCategory) {
        this.weaponCategory = weaponCategory;
    }

    public Set<WeaponComment> getWeaponComments() {
        return weaponComments;
    }

    public void setWeaponComments(Set<WeaponComment> weaponComments) {
        this.weaponComments = weaponComments;
    }
}
