package com.example.project_careerwebsite.controller;

import com.example.project_careerwebsite.domain.Bookmark;
import com.example.project_careerwebsite.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<Bookmark> createBookmark(@RequestBody Bookmark bookmark) {
        Bookmark savedBookmark = bookmarkService.saveBookmark(bookmark);
        return ResponseEntity.ok(savedBookmark);
    }

    // 특정 사용자의 모든 북마크 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bookmark>> getBookmarksByUserId(@PathVariable Long userId) {
        List<Bookmark> bookmarks = bookmarkService.getAllBookmarksByUserId(userId);
        return ResponseEntity.ok(bookmarks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        bookmarkService.deleteBookmark(id);
        return ResponseEntity.ok().build();
    }
}
