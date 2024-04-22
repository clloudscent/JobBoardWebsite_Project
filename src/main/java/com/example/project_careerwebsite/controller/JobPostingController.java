package com.example.project_careerwebsite.controller;

import com.example.project_careerwebsite.domain.JobPosting;
import com.example.project_careerwebsite.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting savedJobPosting = jobPostingService.saveJobPosting(jobPosting);
        return ResponseEntity.ok(savedJobPosting);
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPostingDetails);
        return ResponseEntity.ok(updatedJobPosting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return ResponseEntity.ok().build();
    }
}
