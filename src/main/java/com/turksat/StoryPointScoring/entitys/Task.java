package com.turksat.StoryPointScoring.entitys;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Integer id;
    @Column(name = "name",length = 50)
    private String name;
    private String members;
    private String storyPoints;

    public Task() {
    }

    public Task(Integer id, String name, String members, String storyPoints) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.storyPoints = storyPoints;
    }

    public Task(String name, String members, String storyPoints) {
        this.name = name;
        this.members = members;
        this.storyPoints = storyPoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(String storyPoints) {
        this.storyPoints = storyPoints;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", members='" + members + '\'' +
                ", storyPoints='" + storyPoints + '\'' +
                '}';
    }
}
