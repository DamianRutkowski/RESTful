package com.guns.controller.forum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guns.model.admin.forum.Post;
import com.guns.model.admin.forum.Thread;
import com.guns.spring.service.forum.PostService;
import com.guns.spring.service.forum.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 11-Nov-15.
 */

@RestController
@RequestMapping(value = "api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ThreadService threadService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getAll() {
        return postService.listAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Post create(@RequestBody @Validated Post post) {
        Thread thread = post.getThread();
        post.setThread(threadService.create(thread));

        return postService.create(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Post update(@PathVariable Long id, @RequestBody @Validated Post post) {
        return postService.create(post);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Post post = postService.findById(id);

        postService.delete(post);
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public ThreadService getThreadService() {
        return threadService;
    }

    public void setThreadService(ThreadService threadService) {
        this.threadService = threadService;
    }
}
