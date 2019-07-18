package com.guns.model.common;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Damian Rutkowski on 2015-09-29.
 */

@MappedSuperclass
public class PersistentEntity implements Serializable {
    private static final long serialVersionUID = 2033682106214565973L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(insertable = true, updatable = false)
    private Timestamp creationDate;

    @Column(insertable = false, updatable = true)
    private Timestamp modifyDate;

    @PrePersist
    public void onCreate() {
        this.setCreationDate(new Timestamp(new Date().getTime()));
    }

    @PreUpdate
    public void onUpdate() {
        this.setModifyDate(new Timestamp(new Date().getTime()));
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
