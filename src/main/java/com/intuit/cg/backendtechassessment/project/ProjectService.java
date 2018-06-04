package com.intuit.cg.backendtechassessment.project;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.intuit.cg.backendtechassessment.repository.RepoManager;

@Service
public class ProjectService {
	

	public Collection<Project> getAllProjects() {
		return RepoManager.getAllProjects();
	}

	public Project getProject(String id) {
		return RepoManager.getProject(id);
	}

	public boolean addProject(Project project) {
		return RepoManager.addProject(project);
	}

	public boolean updateProject(String id, Project project) {
		return RepoManager.updateProject(id, project);
	}

	public boolean deleteProject(String id) {
		return RepoManager.deleteProject(id);
	}

	public ProjectDetail getProjectBids(String id) {
		return RepoManager.getProjectBids(id);
	}

}
