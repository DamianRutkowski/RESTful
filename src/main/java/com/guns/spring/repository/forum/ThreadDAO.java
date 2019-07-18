package com.guns.spring.repository.forum;

import com.guns.model.admin.forum.Thread;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 11-Nov-15.
 */
public interface ThreadDAO extends AbstractDAO<Thread, Long> {

}
