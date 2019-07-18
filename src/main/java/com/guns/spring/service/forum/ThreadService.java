package com.guns.spring.service.forum;

import com.guns.model.admin.forum.Thread;
import com.guns.spring.repository.forum.ThreadDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 11-Nov-15.
 */

@Service
public class ThreadService extends AbstractService<Thread> {

    private static final long serialVersionUID = -8727572356595347994L;

    @Autowired
    public ThreadService(ThreadDAO threadDAO) {
        this.abstractDAO = threadDAO;
    }

    private ThreadDAO getDAO() {
        return (ThreadDAO) this.abstractDAO;
    }
}
