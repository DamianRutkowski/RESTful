package com.guns.spring.service.forum;

import com.guns.model.admin.forum.Post;
import com.guns.spring.repository.forum.PostDAO;
import com.guns.spring.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian on 11-Nov-15.
 */

@Service
public class PostService extends AbstractService<Post> {

    private static final long serialVersionUID = 5112061582047763972L;

    @Autowired
    public PostService(PostDAO postDAO) {
        this.abstractDAO = postDAO;
    }

    private PostDAO getDAO() {
        return (PostDAO) this.abstractDAO;
    }
}
