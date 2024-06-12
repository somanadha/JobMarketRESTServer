package com.bst.jms.service;

import com.bst.jms.model.JobPost;
import com.bst.jms.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public class JobPostService {
    @Autowired
    private JobPostRepository repository;

    public JobPost saveJobPost(JobPost jobPost) {
        return repository.save(jobPost);
    }

    public List<JobPost> getAllJobPosts() {
        return repository.findAll();
    }

    public JobPost getJobPost(int id) {
        return repository.findById(id).get();
    }

    public JobPost updateJobPost(JobPost jobPost) {
        return repository.save(jobPost);
    }

    public void deleteJobPost(int id) {
        repository.deleteById(id);
    }

    public Iterable<JobPost> getAllJobsByDescriptionKeyword(String descriptionKeyword) {
        return repository.findByDescriptionContaining(descriptionKeyword);
    }
}
