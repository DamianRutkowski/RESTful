package com.guns.model.admin.forum;

import com.guns.model.admin.user.User;
import com.guns.model.common.PersistentEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian Rutkowski on 2015-11-07.
 */

@Entity
public class Thread extends PersistentEntity {

    private static final long serialVersionUID = -2612289945320324403L;

    private String subject;

    @OneToMany(mappedBy = "thread", targetEntity = Post.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Post> posts;

    @ManyToOne(targetEntity = ForumSubcategory.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private ForumSubcategory forumSubcategory;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User user;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public ForumSubcategory getForumSubcategory() {
        return forumSubcategory;
    }

    public void setForumSubcategory(ForumSubcategory forumSubcategory) {
        this.forumSubcategory = forumSubcategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
