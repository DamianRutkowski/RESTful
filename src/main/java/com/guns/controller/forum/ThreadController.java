package com.guns.controller.forum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guns.model.admin.forum.Thread;
import com.guns.spring.service.forum.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 11-Nov-15.
 */

@RestController
@RequestMapping(value = "api/threads")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Thread> getAll() {
        return threadService.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Thread getById(@PathVariable Long id) {
        return threadService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Thread create(@RequestBody @Validated Thread thread) {
        return threadService.create(thread);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Thread update(@PathVariable Long id, @RequestBody @Validated Thread thread) {
        return threadService.create(thread);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        Thread thread = threadService.findById(id);

        threadService.delete(thread);
    }

    public ThreadService getThreadService() {
        return threadService;
    }

    public void setThreadService(ThreadService threadService) {
        this.threadService = threadService;
    }
}
