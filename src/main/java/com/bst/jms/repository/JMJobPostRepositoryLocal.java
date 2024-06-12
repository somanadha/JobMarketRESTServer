package com.bst.jms.repository;

import com.bst.jms.model.JMJobPost;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope("singleton")
public class JMJobPostRepositoryLocal {
    private final List<JMJobPost> jobPostList = new ArrayList<>();

    public void save(JMJobPost jobPost) {
        jobPostList.add(jobPost);
    }

    public List<JMJobPost> findAll() {
        return jobPostList;
    }

    public JMJobPost find(int id) {
        JMJobPost jobPost = null;
        for (JMJobPost jp :  jobPostList) {
            if (jp.getId() == id) {
                jobPost = jp;
                break;
            }
        }
        return jobPost;
    }

    public JMJobPost update(JMJobPost jobPost) {
        JMJobPost jp = null;
        if (jobPost != null) {
            jp = find(jobPost.getId());
            if (jp != null) {
                jp.update(jobPost);
            }
        }
        return jp;
    }

    public JMJobPost delete(int id) {
        JMJobPost jobPost = null;
        for (JMJobPost jp :  jobPostList) {
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
