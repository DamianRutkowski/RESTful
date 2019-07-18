package com.guns.spring.service.forum;

import com.guns.model.admin.forum.ForumCategory;
import com.guns.spring.repository.forum.ForumCategoryDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 29-May-16.
 */

@Service
public class ForumCategoryService extends AbstractService<ForumCategory> {
    private static final long serialVersionUID = -1729840161413908120L;

    @Autowired
    public ForumCategoryService(ForumCategoryDAO forumCategoryDAO) {
        this.abstractDAO = forumCategoryDAO;
    }

    private ForumCategoryDAO getDAO() {
        return (ForumCategoryDAO) this.abstractDAO;
    }
}
