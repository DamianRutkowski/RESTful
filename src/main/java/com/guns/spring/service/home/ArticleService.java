package com.guns.spring.service.home;

import com.guns.model.admin.home.Article;
import com.guns.spring.repository.home.ArticleDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 29-Nov-15.
 */
@Service
public class ArticleService extends AbstractService<Article> {

    private static final long serialVersionUID = 112097131002031944L;

    @Autowired
    public ArticleService(ArticleDAO articleDAO) {
        this.abstractDAO = articleDAO;
    }

    public Article findByTagName(String tagName) {
        return getDAO().findByTagName(tagName);
    }

    private ArticleDAO getDAO() {
        return (ArticleDAO) this.abstractDAO;
    }
}
