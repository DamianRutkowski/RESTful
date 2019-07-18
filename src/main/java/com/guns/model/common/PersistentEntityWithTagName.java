package com.guns.model.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

/**
 * Created by Damian on 12-Dec-15.
 */

@MappedSuperclass
public class PersistentEntityWithTagName extends PersistentEntity {
    private static final long serialVersionUID = 205563839556478514L;

    @Column(unique = true)
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
