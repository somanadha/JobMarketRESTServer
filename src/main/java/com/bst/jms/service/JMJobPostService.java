package com.bst.jms.service;

import com.bst.jms.model.JMJobPost;
import com.bst.jms.repository.JMJobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("singleton")
public class JMJobPostService {
    @Autowired
    private JMJobPostRepository repository;

    public JMJobPost saveJobPost(JMJobPost jobPost) {
        return repository.save(jobPost);
    }

    public List<JMJobPost> getAllJobPosts() {
        return repository.findAll();
    }

    public JMJobPost getJobPost(int id) {
        return repository.findById(id).get();
    }

    public JMJobPost updateJobPost(JMJobPost jobPost) {
        return repository.save(jobPost);
    }

    public void deleteJobPost(int id) {
        repository.deleteById(id);
    }

    public Iterable<JMJobPost> getAllJobsByDescriptionKeyword(String descriptionKeyword) {
        return repository.findByDescriptionContaining(descriptionKeyword);
    }
}
