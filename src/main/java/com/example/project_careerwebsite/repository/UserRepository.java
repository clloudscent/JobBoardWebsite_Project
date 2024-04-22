package com.example.project_careerwebsite.repository;

import com.example.project_careerwebsite.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

