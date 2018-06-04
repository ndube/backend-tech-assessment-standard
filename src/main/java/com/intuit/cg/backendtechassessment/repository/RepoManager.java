package com.intuit.cg.backendtechassessment.repository;

import java.util.Collection;
import java.util.List;

import com.intuit.cg.backendtechassessment.bid.Bid;
import com.intuit.cg.backendtechassessment.project.Project;
import com.intuit.cg.backendtechassessment.project.ProjectDetail;
import com.intuit.cg.backendtechassessment.user.User;

/**
 * This class's purpose is to manage the Repo Data.
 * As of now this class is not doing much, but in case of a persistent data store,
 * this Manager class will manage the refreshment of cache, pre-validations, any post processing involved, 
 * leaving the Repo class to just store the data.
 */
public class RepoManager {

	public static Collection<Project> getAllProjects() {
		return Repo.getInstance().getAllProjects();
	}

	public static Project getProject(String id) {
		return Repo.getInstance().getProject(id);
	}

	public static boolean addProject(Project project) {
		return Repo.getInstance().addProject(project);
	}

	public static boolean updateProject(String id, Project project) {
		
		String projectId = project.getId();
		
		if (!projectId.equals(id)) {
			return false;
		}
		
		return Repo.getInstance().updateProject(id, project);
	}

	public static boolean deleteProject(String id) {
		return Repo.getInstance().deleteProject(id);
	}

	public static String addBid(Bid bid) {
		return Repo.getInstance().addBid(bid);
	}
	
	public static void updateBid(String id, Bid bid) {
		
		String bidId = bid.getProjectId() + bid.getBidderId();
		
		if (!id.equals(bidId))
			return;
		
		Repo.getInstance().updateBid(id, bid);
	}
	
	public static User getSeller(String id) {
		return Repo.getInstance().getSeller(id);
	}

	public static void addSeller(User seller) {
		Repo.getInstance().addSeller(seller);
	}

	public static Collection<User> getAllSellers() {
		return Repo.getInstance().getAllSellers();
	}

	public static void updateSeller(String id, User seller) {
		Repo.getInstance().updateSeller(id, seller);
	}

	public static void deleteSeller(String id) {
		Repo.getInstance().deleteSeller(id);
	}

	public static Collection<User> getAllBuyers() {
		return Repo.getInstance().getAllBuyers();
	}

	public static User getBuyer(String id) {
		return Repo.getInstance().getBuyer(id);
	}

	public static void addBuyer(User buyer) {
		Repo.getInstance().addBuyer(buyer);
	}

	public static void updateBuyer(String id, User buyer) {
		Repo.getInstance().updateBuyer(id, buyer);
	}

	public static List<Bid> getAllBids() {
		return Repo.getInstance().getAllBids();
	}

	public static ProjectDetail getProjectBids(String projectId) {
		return Repo.getInstance().getProjectBids(projectId);
	}
}
