package com.turksat.StoryPointScoring;

import com.turksat.StoryPointScoring.entitys.User;
import com.turksat.StoryPointScoring.repostoriy.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
      return args -> {
          User ali = new User(
                  1,
                  "Ali",
                  "ali@ali.com",
                  "123",
                  "admin"
          );
          User ayse = new User(
                  "Ayşe",
                  "ayse@ali.com",
                  "123",
                  "user"
          );
          User mehmet = new User(
                  "Mehmet",
                  "mehmet@ali.com",
                  "123",
                  "user"
          );
          User funda = new User(
                  "Funda",
                  "funda@ali.com",
                  "123",
                  "user"
          );
          User hayri = new User(
                  "Hayri",
                  "hayri@ali.com",
                  "123",
                  "user"
          );
          repository.saveAll(
                  List.of(ali,ayse,mehmet,funda,hayri)
          );
      };
    }
}
