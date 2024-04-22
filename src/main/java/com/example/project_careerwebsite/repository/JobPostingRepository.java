package com.example.project_careerwebsite.repository;

import com.example.project_careerwebsite.domain.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}

