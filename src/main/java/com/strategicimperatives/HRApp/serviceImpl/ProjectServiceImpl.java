package com.strategicimperatives.HRApp.serviceImpl;

import com.strategicimperatives.HRApp.entities.Project;
import com.strategicimperatives.HRApp.repositories.ProjectRepository;
import com.strategicimperatives.HRApp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepo;

    @Override
    public Project getById(long id) {
        return projectRepo.getOne(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepo.findAll();
    }

    @Override
    public void addProject(Project project) {
        projectRepo.save(project);
    }

    @Override
    public void deleteProject(long id) {
        projectRepo.delete(projectRepo.getOne(id));
    }

    @Override
    public void updateProject(Project project) {
        Project projectToUpdate = projectRepo.getOne((project.getId()));
        projectToUpdate.setProjectManager(project.getProjectManager());
        projectToUpdate.setName(project.getName());
        projectRepo.save(projectToUpdate);
    }
}
