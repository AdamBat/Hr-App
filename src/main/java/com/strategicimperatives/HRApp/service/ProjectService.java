package com.strategicimperatives.HRApp.service;

import com.strategicimperatives.HRApp.entities.Project;

import java.util.List;

public interface ProjectService {
    Project getById(long id);

    List<Project> findAll();

    void addProject(Project project);

    void deleteProject(long id);

    void updateProject(Project project);

}
