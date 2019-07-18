package com.guns.model.admin.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guns.model.common.PersistentEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian on 21-Nov-15.
 */

@Entity
public class Role extends PersistentEntity implements GrantedAuthority {
    private static final long serialVersionUID = 5573896934450522886L;

    @Transient
    private static final String prefix = "ROLE_";

    @Column(unique = true)
    private String name;

    @Transient
    private String authority;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "ROLE_ID")}, inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    @JsonIgnore
    private Set<User> users;

    @Override
    public String getAuthority() {
        return prefix + name.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
