package com.bst.jms.controller;

import com.bst.jms.model.JMJobPost;
import com.bst.jms.service.JMJobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class JMJobPostController {
    @Autowired
    private JMJobPostService service;

    @PostMapping("jobPost")
    public JMJobPost addJob(JMJobPost jobPost) {
        return service.saveJobPost(jobPost);
    }

    @GetMapping("jobPost/{id}")
    public JMJobPost getJobPost(@PathVariable("id") int id) {
        return service.getJobPost(id);
    }

    @PutMapping("jobPost")
    public JMJobPost updateJobPost(JMJobPost jobPost) {
        return service.updateJobPost(jobPost);
    }

    @DeleteMapping("jobPost/{id}")
    public void deleteJobPost(int id) {
        service.deleteJobPost(id);
    }

    @GetMapping("jobPosts")
    public Iterable<JMJobPost> viewAllJobs(Model model) {
        return service.getAllJobPosts();
    }
    @GetMapping("jobPosts/keyword/{keyword}")
    public Iterable<JMJobPost> getAllJobsByDescriptionKeyword(@PathVariable("keyword") String keyword) {
        return service.getAllJobsByDescriptionKeyword(keyword);
    }
}
