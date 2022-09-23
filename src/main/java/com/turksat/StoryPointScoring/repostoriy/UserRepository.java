package com.turksat.StoryPointScoring.repostoriy;

import com.turksat.StoryPointScoring.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User>findUserByName(String name);

}
