package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.Bookmark;
import java.util.List;

public interface BookmarkService {
    Bookmark saveBookmark(Bookmark bookmark);
    List<Bookmark> getAllBookmarksByUserId(Long userId);
    void deleteBookmark(Long id);
}
