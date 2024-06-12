package com.bst.jms.repository;

import com.bst.jms.model.JMJobPost;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope("singleton")
public interface JMJobPostRepository extends JpaRepository<JMJobPost, Integer> {

    //@Query("select j from JMJobPost j where description")
    //List<JMJobPost> findByDescriptionContainingOrTechStackContaining(String keyword1, String keyword2) ;

    List<JMJobPost> findByDescriptionContaining(String descriptionKeyword) ;

}
