package com.turksat.StoryPointScoring.services;

import com.turksat.StoryPointScoring.entitys.User;
import com.turksat.StoryPointScoring.repostoriy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<User> getUsers(){ return userRepository.findAll();}

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByName(user.getName());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        //Optional<Student> studentOptional = studentRepository.deleteStudentById(studentId);
        boolean exist = userRepository.existsById(userId);
        if (!exist){
            throw new IllegalStateException("this user does not exist!");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Integer userId, String name) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id"+ userId + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(user.getName(),name)){
            user.setName(name);
        }
    }
}
