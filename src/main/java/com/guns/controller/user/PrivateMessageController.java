package com.guns.controller.user;

import com.guns.model.admin.user.PrivateMessage;
import com.guns.spring.service.user.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Damian on 06-Jun-16.
 */

@RestController
@RequestMapping(value = "api/private-messages")
public class PrivateMessageController {

    @Autowired
    private PrivateMessageService privateMessageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PrivateMessage> getAll(@RequestParam(value = "sender", required = false) String sender,
                                       @RequestParam(value = "recipient", required = false) String recipient) {
        if(sender != null) {
            return privateMessageService.findBySenderUsername(sender);
        }
        if(recipient != null) {
            return privateMessageService.findByRecipientUsername(recipient);
        }

        return privateMessageService.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PrivateMessage getById(@PathVariable Long id) {
        return privateMessageService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PrivateMessage create(@RequestBody @Validated PrivateMessage privateMessage) {


        return privateMessageService.create(privateMessage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PrivateMessage update(@PathVariable Long id, @RequestBody @Validated PrivateMessage privateMessage) {
        return privateMessageService.create(privateMessage);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        PrivateMessage privateMessage = privateMessageService.findById(id);

        privateMessageService.delete(privateMessage);
    }

    /*
    @RequestMapping(value = "/sender/{username}", method = RequestMethod.GET)
    public List<PrivateMessage> getBySenderUsername(@PathVariable String username) {
        return privateMessageService.findBySenderUsername(username);
    }

    @RequestMapping(value = "/recipient/{username}", method = RequestMethod.GET)
    public List<PrivateMessage> getByRecipientUsername(@PathVariable String username) {
        return privateMessageService.findByRecipientUsername(username);
    }
    */

    public PrivateMessageService getPrivateMessageService() {
        return privateMessageService;
    }

    public void setPrivateMessageService(PrivateMessageService privateMessageService) {
        this.privateMessageService = privateMessageService;
    }
}
