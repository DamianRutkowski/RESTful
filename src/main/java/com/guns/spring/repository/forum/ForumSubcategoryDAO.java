package com.guns.spring.repository.forum;

import com.guns.model.admin.forum.ForumSubcategory;
import com.guns.spring.repository.AbstractDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Damian on 29-May-16.
 */
public interface ForumSubcategoryDAO extends AbstractDAO<ForumSubcategory, Long> {

    @Query("SELECT c FROM ForumSubcategory c WHERE c.tagName = (:tagName)")
    ForumSubcategory findByTagName(@Param("tagName") String tagName);
}
