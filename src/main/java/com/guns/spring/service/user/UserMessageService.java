package com.guns.spring.service.user;

import com.guns.model.admin.user.UserMessage;
import com.guns.spring.repository.user.UserMessageDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 04-Jun-16.
 */

@Service
public class UserMessageService extends AbstractService<UserMessage> {
    private static final long serialVersionUID = 1176244427005928866L;

    @Autowired
    public UserMessageService(UserMessageDAO userMessageDAO) {
        this.abstractDAO = userMessageDAO;
    }

    private UserMessageDAO getDAO() {
        return (UserMessageDAO) this.abstractDAO;
    }

    public List<UserMessage> findByTargetUsername(String username) {
        return getDAO().findByTargetUsername(username);
    }

    public List<UserMessage> findByAuthorUsername(String username) {
        return getDAO().findByAuthorUsername(username);
    }
}
