package com.example.project_careerwebsite.service;

import com.example.project_careerwebsite.domain.User;
import com.example.project_careerwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        // 사용자 정보를 찾고 없으면 예외를 발생시킵니다.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found for this id :: " + id));

        // userDetails의 값으로 user 객체의 정보를 업데이트합니다.
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        // 필요하다면 여기에 추가적인 필드 업데이트 로직을 포함시킬 수 있습니다.

        // 변경된 정보로 사용자 정보를 데이터베이스에 저장합니다.
        final User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        // 삭제할 사용자 정보를 찾고 없으면 예외를 발생시킵니다.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found for this id :: " + id));

        // 사용자 정보를 데이터베이스에서 삭제합니다.
        userRepository.delete(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean isValidUser(String username, String password) {
        return false;
    }
}
