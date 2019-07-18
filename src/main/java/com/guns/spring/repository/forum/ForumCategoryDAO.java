package com.guns.spring.repository.forum;

import com.guns.model.admin.forum.ForumCategory;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 29-May-16.
 */
public interface ForumCategoryDAO extends AbstractDAO<ForumCategory, Long> {
}
