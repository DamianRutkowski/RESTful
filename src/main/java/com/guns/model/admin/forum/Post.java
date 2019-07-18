package com.guns.model.admin.forum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.admin.user.User;
import com.guns.model.common.PersistentEntity;

import javax.persistence.*;

/**
 * Created by Damian Rutkowski on 2015-11-07.
 */

@Entity
public class Post extends PersistentEntity {
    private static final long serialVersionUID = -5330892435757675637L;

    private String content;

    @ManyToOne(targetEntity = Thread.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Thread thread;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
