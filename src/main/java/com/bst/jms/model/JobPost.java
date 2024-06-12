package com.bst.jms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Entity
public class JobPost {
    @Id
    private int id;
    private String profile;
    private String description;
    private byte experience;
    private ArrayList<String> techStack;

    public void update(JobPost jobPost) {
        this.id = jobPost.id;
        this.profile = jobPost.profile;
        this.description = jobPost.description;
        this.experience = jobPost.experience;
        this.techStack = jobPost.techStack;
    }
}
