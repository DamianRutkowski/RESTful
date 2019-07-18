package com.guns.spring.service.forum;

import com.guns.model.admin.forum.ForumSubcategory;
import com.guns.spring.repository.forum.ForumSubcategoryDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 29-May-16.
 */

@Service
public class ForumSubcategoryService extends AbstractService<ForumSubcategory> {
    private static final long serialVersionUID = -3938323236854751930L;

    @Autowired
    public ForumSubcategoryService(ForumSubcategoryDAO forumSubcategoryDAO) {
        this.abstractDAO = forumSubcategoryDAO;
    }

    public ForumSubcategory findByTagName(String tagName) {
        return getDAO().findByTagName(tagName);
    }

    private ForumSubcategoryDAO getDAO() {
        return (ForumSubcategoryDAO) this.abstractDAO;
    }
}
