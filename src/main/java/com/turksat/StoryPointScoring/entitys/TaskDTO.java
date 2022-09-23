package com.turksat.StoryPointScoring.entitys;

import java.util.List;

public class TaskDTO {
    private String name;
    private List<String> member;
    private List<String> storyPoints;

    public TaskDTO(String name, List<String> member, List<String> storyPoints) {
        this.name = name;
        this.member = member;
        this.storyPoints = storyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMember() {
        return member;
    }

    public void setMember(List<String> member) {
        this.member = member;
    }

    public List<String> getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(List<String> storyPoints) {
        this.storyPoints = storyPoints;
    }
}
