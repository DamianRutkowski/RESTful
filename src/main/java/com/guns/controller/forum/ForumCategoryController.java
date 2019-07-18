package com.guns.controller.forum;

import com.guns.model.admin.forum.ForumCategory;
import com.guns.spring.service.forum.ForumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 29-May-16.
 */

@RestController
@RequestMapping(value = "api/forum-categories")
public class ForumCategoryController {

    @Autowired
    private ForumCategoryService forumCategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ForumCategory> getAll() {
        return forumCategoryService.listAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ForumCategory create(@RequestBody @Validated ForumCategory forumCategory) {
        return forumCategoryService.create(forumCategory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ForumCategory update(@PathVariable Long id, @RequestBody @Validated ForumCategory forumCategory) {
        return forumCategoryService.create(forumCategory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        ForumCategory forumCategory = forumCategoryService.findById(id);

        forumCategoryService.delete(forumCategory);
    }

    public ForumCategoryService getForumCategoryService() {
        return forumCategoryService;
    }

    public void setForumCategoryService(ForumCategoryService forumCategoryService) {
        this.forumCategoryService = forumCategoryService;
    }
}
