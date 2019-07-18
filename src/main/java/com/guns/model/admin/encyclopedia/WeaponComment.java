package com.guns.model.admin.encyclopedia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.admin.user.User;
import com.guns.model.common.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Damian on 26-May-16.
 */

@Entity
public class WeaponComment extends PersistentEntity {
    private static final long serialVersionUID = -2576755263813468293L;

    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User author;

    @ManyToOne(targetEntity = Weapon.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
