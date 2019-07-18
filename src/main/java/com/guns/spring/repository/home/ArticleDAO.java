package com.guns.spring.repository.home;

import com.guns.model.admin.home.Article;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 29-Nov-15.
 */
public interface ArticleDAO extends AbstractDAO<Article, Long> {

    @Query("SELECT a FROM Article a WHERE a.tagName = (:tagName)")
    Article findByTagName(@Param("tagName") String tagName);
}
