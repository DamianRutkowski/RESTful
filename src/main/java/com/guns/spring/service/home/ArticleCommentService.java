package com.guns.spring.service.home;

import com.guns.model.admin.home.ArticleComment;
import com.guns.spring.repository.home.ArticleCommentDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 26-May-16.
 */
@Service
public class ArticleCommentService extends AbstractService<ArticleComment> {
    private static final long serialVersionUID = -8818668703032640690L;

    @Autowired
    public ArticleCommentService(ArticleCommentDAO articleCommentDAO) {
        this.abstractDAO = articleCommentDAO;
    }

    private ArticleCommentDAO getDAO() {
        return (ArticleCommentDAO) this.abstractDAO;
    }
}
