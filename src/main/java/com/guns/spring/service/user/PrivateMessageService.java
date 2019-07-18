package com.guns.spring.service.user;

import com.guns.model.admin.user.PrivateMessage;
import com.guns.spring.repository.user.PrivateMessageDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian on 04-Jun-16.
 */

@Service
public class PrivateMessageService extends AbstractService<PrivateMessage> {
    private static final long serialVersionUID = 4451934723349577826L;

    @Autowired
    public PrivateMessageService(PrivateMessageDAO privateMessageDAO) {
        this.abstractDAO = privateMessageDAO;
    }

    private PrivateMessageDAO getDAO() {
        return (PrivateMessageDAO) this.abstractDAO;
    }

    public List<PrivateMessage> findBySenderUsername(String username) {
        return getDAO().findBySenderUsername(username);
    }

    public List<PrivateMessage> findByRecipientUsername(String username) {
        return getDAO().findByRecipientUsername(username);
    }
}
