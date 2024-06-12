package com.bst.jms.repository;

import com.bst.jms.model.JobPost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class JobPostRepositoryLocal {
    private final List<JobPost> jobPostList = new ArrayList<>();

    public void save(JobPost jobPost) {
        jobPostList.add(jobPost);
    }

    public List<JobPost> findAll() {
        return jobPostList;
    }

    public JobPost find(int id) {
        JobPost jobPost = null;
        for (JobPost jp :  jobPostList) {
            if (jp.getId() == id) {
                jobPost = jp;
                break;
            }
        }
        return jobPost;
    }

    public JobPost update(JobPost jobPost) {
        JobPost jp = null;
        if (jobPost != null) {
            jp = find(jobPost.getId());
            if (jp != null) {
                jp.update(jobPost);
            }
        }
        return jp;
    }

    public JobPost delete(int id) {
        JobPost jobPost = null;
        for (JobPost jp :  jobPostList) {
            if (jp.getId() == id) {
                jobPost = jp;
                break;
            }
        }
        if (jobPost != null) {
            jobPostList.remove(jobPost);
        }
        return jobPost;
    }
}
