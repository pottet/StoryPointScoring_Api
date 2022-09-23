package com.turksat.StoryPointScoring;

import com.turksat.StoryPointScoring.entitys.Task;

import com.turksat.StoryPointScoring.repostoriy.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class TaskConfig {
    /*List<String> names = Arrays.asList("deneme", "deneme1");
    List<String> members = Arrays.asList("Ali", "Veli");
    List<String> storyPoints = Arrays.asList("1", "2","5","13");

        @Bean
        CommandLineRunner commandLineRunner2(TaskRepository repository){
            return args -> {
                for (String name : names)
                {
                    for (String member : members)
                    {
                        for (String storyPoint : storyPoints)
                        {
                            Task data = new Task(
                                    name,
                                    member,
                                    storyPoint
                            );
                            repository.save(data);
                        }
                    }
                }
            };
        }*/
}
