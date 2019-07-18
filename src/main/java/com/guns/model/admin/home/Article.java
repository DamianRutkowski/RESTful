package com.guns.model.admin.home;

import com.guns.model.admin.user.User;
import com.guns.model.common.PersistentEntityWithTagName;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Damian on 29-Nov-15.
 */

@Entity
public class Article extends PersistentEntityWithTagName {

    private static final long serialVersionUID = -3280892730392517089L;

    private String subject;

    @Column(length = 1500)
    private String teaser;

    @Column(length = 5500)
    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User author;

    @OneToMany(targetEntity = ArticleComment.class, fetch = FetchType.EAGER, mappedBy = "article")
    private Set<ArticleComment> articleComments;


    public String getTeaser() {
        return teaser;
    }

    public void getTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<ArticleComment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(Set<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }
}
