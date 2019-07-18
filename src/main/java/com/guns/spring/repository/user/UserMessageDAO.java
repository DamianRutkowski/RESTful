package com.guns.spring.repository.user;

import com.guns.model.admin.user.UserMessage;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Damian on 04-Jun-16.
 */
public interface UserMessageDAO extends AbstractDAO<UserMessage, Long> {

    @Query("SELECT um FROM UserMessage um WHERE um.targetUser.username = :username")
    public List<UserMessage> findByTargetUsername(@Param("username") String username);

    @Query("SELECT um FROM UserMessage um WHERE um.author.username = :username")
    public List<UserMessage> findByAuthorUsername(@Param("username") String username);
}
