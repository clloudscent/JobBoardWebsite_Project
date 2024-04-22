package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.Bookmark;
import com.example.project_careerwebsite.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Override
    public Bookmark saveBookmark(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @Override
    public List<Bookmark> getAllBookmarksByUserId(Long userId) {
        return bookmarkRepository.findAll().stream()
                .filter(bookmark -> bookmark.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookmark(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bookmark not found for this id :: " + id));
        bookmarkRepository.delete(bookmark);
    }
}

