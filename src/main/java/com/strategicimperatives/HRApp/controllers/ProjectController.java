package com.strategicimperatives.HRApp.controllers;

import com.strategicimperatives.HRApp.entities.Project;
import com.strategicimperatives.HRApp.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    @Autowired
    ProjectServiceImpl projectService;


    @RequestMapping(value = "/listAllProjects", method = RequestMethod.GET)
    public ResponseEntity listAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @RequestMapping(value = "/addNewProject", method = RequestMethod.POST)
    public ResponseEntity addNewProject(Project newProject) {
        projectService.addProject(newProject);
        return ResponseEntity.ok("Project " + newProject.getName() + " successfully added");
    }

    @RequestMapping(value = "/deleteProject", method = RequestMethod.DELETE)
    public ResponseEntity deleteProject(long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project " + projectService.getById(id).getName() + " successfully deleted");
    }

    @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
    public ResponseEntity updateProject(Project project) {
        projectService.updateProject(project);
        return ResponseEntity.ok("Project " + project.getName() + " successfully updated");
    }

}
