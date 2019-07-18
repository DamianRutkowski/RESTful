package com.guns.controller.home;

import com.guns.model.admin.home.Article;
import com.guns.spring.service.home.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 29-Nov-15.
 */

@RestController
@RequestMapping("api/articles")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Article> getAll() {
        return articleService.listAll();
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
    public Article getByTagName(@PathVariable String tagName) {
        return articleService.findByTagName(tagName);
    }


    @RequestMapping(value = "/{tagName}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("tagName") String tagName) {
        Article article = articleService.findByTagName(tagName);
        articleService.delete(article);

        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.POST)
    public Article create(@PathVariable String tagName, @RequestBody @Validated Article article) {
        return articleService.create(article);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.PUT)
    public Article update(@PathVariable String tagName, @RequestBody @Validated Article article) {
        return articleService.create(article);
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
