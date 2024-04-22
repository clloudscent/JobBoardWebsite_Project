package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.JobPosting;
import java.util.List;

public interface JobPostingService {
    JobPosting saveJobPosting(JobPosting jobPosting);
    JobPosting updateJobPosting(Long id, JobPosting jobPosting);
    List<JobPosting> getAllJobPostings();
    JobPosting getJobPostingById(Long id);
    void deleteJobPosting(Long id);
}
