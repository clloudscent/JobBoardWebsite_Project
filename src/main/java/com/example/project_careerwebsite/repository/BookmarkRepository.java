package com.example.project_careerwebsite.repository;

import com.example.project_careerwebsite.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
