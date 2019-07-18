package com.guns.model.admin.user;

import com.guns.model.common.PersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by Damian on 04-Jun-16.
 */

@Entity
public class PrivateMessage extends PersistentEntity{
    private static final long serialVersionUID = 2887662100426524312L;

    private String subject;

    @Column(nullable = false)
    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User sender;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User recipient;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
