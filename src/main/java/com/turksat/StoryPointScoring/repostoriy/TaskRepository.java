package com.turksat.StoryPointScoring.repostoriy;

import com.turksat.StoryPointScoring.entitys.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    //@Query("SELECT s from Student s WHERE s.email =?1")
    Optional<Task> findTaskByName(String name);
    Optional<Task> findTaskByMembers(String member);
    Optional<Task> findTaskByStoryPoints(String storyPoint);
}
