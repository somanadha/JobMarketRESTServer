package com.bst.jms.controller;

import com.bst.jms.model.JobPost;
import com.bst.jms.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class JobMarketController {
    @Autowired
    private JobPostService service;

    @PostMapping("JobPost")
    public JobPost addJob(JobPost jobPost) {
        return service.saveJobPost(jobPost);
    }

    @GetMapping("JobPost/{id}")
    public JobPost getJobPost(@PathVariable("id") int id) {
        return service.getJobPost(id);
    }

    @PutMapping("JobPost")
    public JobPost updateJobPost(JobPost jobPost) {
        return service.updateJobPost(jobPost);
    }

    @DeleteMapping("JobPost/{id}")
    public void deleteJobPost(int id) {
        service.deleteJobPost(id);
    }

    @GetMapping("JobPosts")
    public Iterable<JobPost> viewAllJobs(Model model) {
        return service.getAllJobPosts();
    }
    @GetMapping("JobPosts/keyword/{keyword}")
    public Iterable<JobPost> getAllJobsByDescriptionKeyword(@PathVariable("keyword") String keyword) {
        return service.getAllJobsByDescriptionKeyword(keyword);
    }
}
