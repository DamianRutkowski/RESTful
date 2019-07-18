package com.guns.model.admin.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.admin.encyclopedia.WeaponComment;
import com.guns.model.admin.forum.Post;
import com.guns.model.admin.forum.Thread;
import com.guns.model.admin.home.Article;
import com.guns.model.admin.home.ArticleComment;
import com.guns.model.common.PersistentEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Damian on 21-Nov-15.
 */

@Entity
public class User extends PersistentEntity implements UserDetails {
    private static final long serialVersionUID = -4547871200691060479L;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

    @OneToMany(targetEntity = Thread.class, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<Thread> threads;

    @OneToMany(targetEntity = Article.class, fetch = FetchType.EAGER, mappedBy = "author")
    @JsonIgnore
    private Set<Article> articles;

    @OneToMany(targetEntity = Post.class, fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Set<Post> posts;

    @OneToMany(targetEntity = ArticleComment.class, fetch = FetchType.EAGER, mappedBy = "author")
    @JsonIgnore
    private Set<ArticleComment> articleComments;

    @OneToMany(targetEntity = WeaponComment.class, fetch = FetchType.EAGER, mappedBy = "author")
    @JsonIgnore
    private Set<WeaponComment> weaponComments;

    @OneToMany(targetEntity = PrivateMessage.class, fetch = FetchType.EAGER, mappedBy = "sender")
    @JsonIgnore
    private Set<PrivateMessage> postedMessages;

    @OneToMany(targetEntity = PrivateMessage.class, fetch = FetchType.EAGER, mappedBy = "recipient")
    @JsonIgnore
    private Set<PrivateMessage> receivedMessages;

    @OneToMany(targetEntity = UserMessage.class, fetch = FetchType.EAGER, mappedBy = "targetUser")
    @JsonIgnore
    private Set<UserMessage> profileMessages;

    @OneToMany(targetEntity = UserMessage.class, fetch = FetchType.EAGER, mappedBy = "author")
    @JsonIgnore
    private Set<UserMessage> createdProfileMessages;

    @Column(nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private Boolean enabled = false;

    private Boolean isActivated = false;

    private String activationToken;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.addAll(getRoles());

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Thread> getThreads() {
        return threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<ArticleComment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(Set<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }

    public Set<WeaponComment> getWeaponComments() {
        return weaponComments;
    }

    public void setWeaponComments(Set<WeaponComment> weaponComments) {
        this.weaponComments = weaponComments;
    }

    public Set<PrivateMessage> getPostedMessages() {
        return postedMessages;
    }

    public void setPostedMessages(Set<PrivateMessage> postedMessages) {
        this.postedMessages = postedMessages;
    }

    public Set<PrivateMessage> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Set<PrivateMessage> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public Set<UserMessage> getProfileMessages() {
        return profileMessages;
    }

    public void setProfileMessages(Set<UserMessage> profileMessages) {
        this.profileMessages = profileMessages;
    }

    public Set<UserMessage> getCreatedProfileMessages() {
        return createdProfileMessages;
    }

    public void setCreatedProfileMessages(Set<UserMessage> createdProfileMessages) {
        this.createdProfileMessages = createdProfileMessages;
    }

    public Boolean getActivated() {
        return isActivated;
    }

    public void setActivated(Boolean activated) {
        isActivated = activated;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
    }
}
