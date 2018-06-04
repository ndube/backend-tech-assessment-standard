package com.intuit.cg.backendtechassessment.project;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(RequestMappings.PROJECTS)
	public Collection<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping(RequestMappings.PROJECTS + "/{id}")
	public Project getProject(@PathVariable String id){
		return projectService.getProject(id);
	}
	
	@RequestMapping(RequestMappings.PROJECTS + "/{id}" + "/" + RequestMappings.BIDS)
	public ProjectDetail getProjectBids(@PathVariable String id){
		return projectService.getProjectBids(id);
	}
	
	@RequestMapping(method=RequestMethod.POST ,value=RequestMappings.PROJECTS)
	public void addProject(@RequestBody Project project){
		projectService.addProject(project);
	}
	
	@RequestMapping(method=RequestMethod.PUT ,value=RequestMappings.PROJECTS + "/{id}")
	public void updateProject(@RequestBody Project project, @PathVariable String id){
		projectService.updateProject(id, project);
	}
	
	@RequestMapping(method=RequestMethod.DELETE ,value=RequestMappings.PROJECTS + "/{id}")
	public void deleteProject(@PathVariable String id){
		projectService.deleteProject(id);
	}

}
