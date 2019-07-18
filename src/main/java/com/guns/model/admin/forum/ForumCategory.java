package com.guns.model.admin.forum;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.guns.model.common.PersistentEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Damian Rutkowski on 2015-10-10.
 */

@Entity
public class ForumCategory extends PersistentEntity {

    private static final long serialVersionUID = 4447882212831861288L;

    @Column
    private String name;

    @OneToMany(mappedBy = "category", targetEntity = ForumSubcategory.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ForumSubcategory> subcategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ForumSubcategory> getSubcategory() {
        return subcategories;
    }

    public void setSubcategory(List<ForumSubcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
