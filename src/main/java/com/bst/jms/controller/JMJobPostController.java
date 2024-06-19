package com.bst.jms.controller;

import com.bst.jms.model.JMJobPost;
import com.bst.jms.service.JMJobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class JMJobPostController {
    @Autowired
    private JMJobPostService service;

    @PostMapping("jobPost")
    public JMJobPost addJob(@RequestBody JMJobPost jobPost) {
        return service.saveJobPost(jobPost);
    }

    @GetMapping("jobPost/{id}")
    public JMJobPost getJobPost(@PathVariable("id") int id) {
        return service.getJobPost(id);
    }

    @PutMapping("jobPost")
    public JMJobPost updateJobPost(@RequestBody JMJobPost jobPost) {
        return service.updateJobPost(jobPost);
    }

    @DeleteMapping("jobPost/{id}")
    public void deleteJobPost(@PathVariable("id") int id) {
        service.deleteJobPost(id);
    }

    @GetMapping("jobPosts")
    public Iterable<JMJobPost> viewAllJobs() {
        return service.getAllJobPosts();
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public Iterable<JMJobPost> getAllJobsByDescriptionKeyword(@PathVariable("keyword") String keyword) {
        return service.getAllJobsByDescriptionKeyword(keyword);
    }
}
