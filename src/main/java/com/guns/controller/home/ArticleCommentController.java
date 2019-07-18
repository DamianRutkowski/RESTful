package com.guns.controller.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guns.model.admin.home.Article;
import com.guns.model.admin.home.ArticleComment;
import com.guns.spring.service.home.ArticleCommentService;
import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damian on 26-May-16.
 */

@RestController
@RequestMapping(value = "api/article-comments")
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService articleCommentService;

    @RequestMapping(method = RequestMethod.POST)
    public ArticleComment create(@RequestBody @Validated ArticleComment articleComment) throws Exception {
        return articleCommentService.create(articleComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ArticleComment update(@PathVariable Long id, @RequestBody @Validated ArticleComment articleComment) throws Exception {
        return articleCommentService.create(articleComment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        ArticleComment articleComment = articleCommentService.findById(id);

        articleCommentService.delete(articleComment);
    }

    public ArticleCommentService getArticleCommentService() {
        return articleCommentService;
    }

    public void setArticleCommentService(ArticleCommentService articleCommentService) {
        this.articleCommentService = articleCommentService;
    }
}
