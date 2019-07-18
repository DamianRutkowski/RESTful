package com.guns.model.admin.home;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guns.model.admin.user.User;
import com.guns.model.common.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Damian on 26-May-16.
 */

@Entity
public class ArticleComment extends PersistentEntity {
    private static final long serialVersionUID = -8054740616845224846L;

    private String content;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User author;

    @ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Article article;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
