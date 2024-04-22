package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.JobPosting;
import com.example.project_careerwebsite.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public JobPosting saveJobPosting(JobPosting jobPosting) {
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Posting not found for this id :: " + id));
        jobPosting.setPositionTitle(jobPostingDetails.getPositionTitle());
        jobPosting.setCompanyName(jobPostingDetails.getCompanyName());
        jobPosting.setLocation(jobPostingDetails.getLocation());
        jobPosting.setJobDescription(jobPostingDetails.getJobDescription());
        final JobPosting updatedJobPosting = jobPostingRepository.save(jobPosting);
        return updatedJobPosting;
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    @Override
    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Posting not found for this id :: " + id));
    }

    @Override
    public void deleteJobPosting(Long id) {
        JobPosting jobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job Posting not found for this id :: " + id));
        jobPostingRepository.delete(jobPosting);
    }
}
