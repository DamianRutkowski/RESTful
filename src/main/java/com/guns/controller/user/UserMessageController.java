package com.guns.controller.user;

import com.guns.model.admin.user.User;
import com.guns.model.admin.user.UserMessage;
import com.guns.spring.service.user.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 06-Jun-16.
 */

@RestController
@RequestMapping(value = "api/user-messages")
public class UserMessageController {

    @Autowired
    private UserMessageService userMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserMessage> getAll(@RequestParam(value = "targetUser", required = false) String targetUser,
                                    @RequestParam(value = "author", required = false) String author) {
        if (targetUser != null) {
            return userMessageService.findByTargetUsername(targetUser);
        }
        if (author != null) {
            return userMessageService.findByAuthorUsername(author);
        }

        return userMessageService.listAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserMessage create(@RequestBody @Validated UserMessage userMessage) {
        return userMessageService.create(userMessage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserMessage update(@PathVariable Long id, @RequestBody @Validated UserMessage userMessage) {
        return userMessageService.create(userMessage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        UserMessage userMessage = userMessageService.findById(id);

        userMessageService.delete(userMessage);
    }

    public UserMessageService getUserMessageService() {
        return userMessageService;
    }

    public void setUserMessageService(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }
}
