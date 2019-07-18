package com.guns.model.admin.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.common.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Damian on 04-Jun-16.
 */

@Entity
public class UserMessage extends PersistentEntity {
    private static final long serialVersionUID = -1473482531975467224L;

    @Column(nullable = false)
    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User targetUser;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User author;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(User targetUser) {
        this.targetUser = targetUser;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
