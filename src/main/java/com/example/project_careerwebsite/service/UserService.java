package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.User;
import java.util.List;

public interface UserService {
    User saveUser(User user); // 사용자 생성

    List<User> getAllUsers(); // 모든 사용자 조회

    User updateUser(Long id, User userDetails); // 사용자 정보 업데이트

    void deleteUser(Long id); // 사용자 삭제

    User getUserByUsername(String username);

    boolean isValidUser(String username, String password);


}
