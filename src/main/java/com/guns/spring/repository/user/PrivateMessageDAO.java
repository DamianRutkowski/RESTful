package com.guns.spring.repository.user;

import com.guns.model.admin.user.PrivateMessage;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damian on 04-Jun-16.
 */

public interface PrivateMessageDAO extends AbstractDAO<PrivateMessage, Long> {

    @Query("SELECT pm FROM PrivateMessage pm WHERE pm.sender.username = :username")
    public List<PrivateMessage> findBySenderUsername(@Param("username") String username);

    @Query("SELECT pm FROM PrivateMessage pm WHERE pm.recipient.username = :username")
    public List<PrivateMessage> findByRecipientUsername(@Param("username") String username);
}
