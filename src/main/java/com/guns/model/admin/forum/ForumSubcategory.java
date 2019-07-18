package com.guns.model.admin.forum;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.common.PersistentEntityWithTagName;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian on 29-May-16.
 */

@Entity
public class ForumSubcategory extends PersistentEntityWithTagName{
    private static final long serialVersionUID = -386885548197258848L;

    @Column
    private String name;

    @ManyToOne(targetEntity = ForumCategory.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ForumCategory category;

    @OneToMany(targetEntity = Thread.class, fetch = FetchType.EAGER, mappedBy = "forumSubcategory", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Thread> threads;

    public Set<Thread> getThreads() {
        return threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

    public ForumCategory getCategory() {
        return category;
    }

    public void setCategory(ForumCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
