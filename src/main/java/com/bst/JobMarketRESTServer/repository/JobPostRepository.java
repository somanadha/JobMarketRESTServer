package com.bst.JobMarketRESTServer.repository;

import com.bst.JobMarketRESTServer.model.JobPost;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    //@Query("select j from JobPost j where description")
    //List<JobPost> findByDescriptionContainingOrTechStackContaining(String keyword1, String keyword2) ;

    List<JobPost> findByDescriptionContaining(String descriptionKeyword) ;

}
