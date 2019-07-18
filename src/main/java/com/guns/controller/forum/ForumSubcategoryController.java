package com.guns.controller.forum;

import com.guns.model.admin.forum.ForumCategory;
import com.guns.model.admin.forum.ForumSubcategory;
import com.guns.model.admin.forum.Thread;
import com.guns.spring.service.forum.ForumSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Damian on 29-May-16.
 */

@RestController
@RequestMapping(value = "api/forum-subcategories")
public class ForumSubcategoryController {

    @Autowired
    private ForumSubcategoryService forumSubcategoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ForumSubcategory> getAll() {
        return forumSubcategoryService.listAll();
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
    public ForumSubcategory getByTagName(@PathVariable String tagName) {
        return forumSubcategoryService.findByTagName(tagName);
    }

    @RequestMapping(value = "/{tagName}/threads", method = RequestMethod.GET)
    public List<Thread> getThreads(@PathVariable String tagName) {
        return new ArrayList<Thread>(forumSubcategoryService.findByTagName(tagName).getThreads());
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.POST)
    public ForumSubcategory create(@PathVariable String tagName, @RequestBody @Validated ForumSubcategory forumSubcategory) {
        return forumSubcategoryService.create(forumSubcategory);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.PUT)
    public ForumSubcategory update(@PathVariable String tagName, @RequestBody @Validated ForumSubcategory forumSubcategory) {
        return forumSubcategoryService.create(forumSubcategory);
    }

    @RequestMapping(value = "/{tagName}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String tagName) {
        ForumSubcategory forumSubcategory = forumSubcategoryService.findByTagName(tagName);

        forumSubcategoryService.delete(forumSubcategory);
    }

    public ForumSubcategoryService getForumSubcategoryService() {
        return forumSubcategoryService;
    }

    public void setForumSubcategoryService(ForumSubcategoryService forumSubcategoryService) {
        this.forumSubcategoryService = forumSubcategoryService;
    }
}
