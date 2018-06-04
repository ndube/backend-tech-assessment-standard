package com.intuit.cg.backendtechassessment.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.intuit.cg.backendtechassessment.bid.Bid;
import com.intuit.cg.backendtechassessment.bid.BidStatus;
import com.intuit.cg.backendtechassessment.project.Project;
import com.intuit.cg.backendtechassessment.project.ProjectDetail;
import com.intuit.cg.backendtechassessment.user.User;

/**
 * 
 * Singleton Class used to store all Project, User and Bid data In-Memory
 *
 */
public class Repo {
	
	private static Repo sRepo;
	
	private Map<String, Project> projects = new HashMap<>();
	private Map<String, User> sellers = new HashMap<>();
	private Map<String, User> buyers = new HashMap<>();

	private Map<String, BidQueue> proToBidQ = new HashMap<>();
	

	private Map<String, Set<Bid>> buyerToBid = new HashMap<>();

	private Map<String, Set<Project>> sellerToProject = new HashMap<>();

	
	private Repo() {}
	
	public static Repo getInstance() {
		if (sRepo == null) {
			synchronized(Repo.class) {
				if (sRepo == null) {
					sRepo = new Repo();
				}
			}
		}
		return sRepo;
	}

	public Collection<Project> getAllProjects() {
		//return Collections.unmodifiableCollection(projects.values()); //TODO make it more solid
		List<Project> allProjects = new ArrayList<>();
		
		for (String id: this.projects.keySet()) {
			allProjects.add(getProject(id));
		}
		
		return allProjects;
	}

	public Project getProject(String id) {
		Project project = projects.get(id);
		
		if (project == null) {
			return null;
		}
		BidQueue bidQ = proToBidQ.get(id);
		if (bidQ != null) {
			Bid lowestBid = proToBidQ.get(id).min();
			project.setLowestBid(lowestBid);//TODO add null check
			
			Date now = new Date();
			if (now.after(project.getBidDeadline())) {
				lowestBid.setBidStatus(BidStatus.WON);
				bidQ.updateBidStatus(BidStatus.LOST);
			}
		}
		
		return project; //TODO return a copy
	}

	public synchronized boolean addProject(Project project) {
		
		if (projects.containsKey(project.getId()))
			return false;
		
		projects.put(project.getId(), project);
		
		String posterId = project.getPostedBy();
		
		Set<Project> projectSet = sellerToProject.get(posterId);
		
		if (projectSet == null) {
			projectSet = new HashSet<>();
			sellerToProject.put(posterId, projectSet);
		}
		projectSet.add(project);
		
		return true;
	}

	public synchronized boolean updateProject(String id, Project project) {
		
		if (!projects.containsKey(project.getId()))
			return false;
		
		Project old = projects.get(id);
		
		if (!old.getId().equals(project.getId())) {
			// throw an exception, saying cannot change name
		}
		
		if (!old.getPostedBy().equals(project.getPostedBy())) {
			// throw an exception, saying cannot change the Job poster
		}
		
		old.update(project);
		
		return true;
	}

	public synchronized boolean deleteProject(String id) {
		
		if (!projects.containsKey(id))
			return false;
		
		projects.remove(id);
		proToBidQ.remove(id);
		
		return true;
	}

	public synchronized String addBid(Bid bid) {
		
		bid.setBidLastUpdatedOn(new Date());
		BidQueue bidQ = proToBidQ.get(bid.getProjectId());
		if (bidQ == null)
			bidQ = new BidQueue();
		bidQ.addBid(bid);
		proToBidQ.put(bid.getProjectId(), bidQ);
		
		String bidderId = bid.getBidderId();
		Set<Bid> userBids = buyerToBid.get(bidderId);
		if (userBids == null) {
			userBids = new HashSet<>();
			buyerToBid.put(bidderId, userBids);
		}
		userBids.add(bid);
		
		return bid.getBidderId();
	}
	
	public void updateBid(String id, Bid bid) {
		
		bid.setBidLastUpdatedOn(new Date());
		
		BidQueue bidQ = proToBidQ.get(bid.getProjectId());
		bidQ.updateBid(bid);
	}

	public void addSeller(User seller) {
		sellers.put(seller.getId(), seller);
	}
	
	public User getSeller(String id) {
		return sellers.get(id);
	}

	public Collection<User> getAllSellers() {
		return Collections.unmodifiableCollection(sellers.values()); //TODO make it more solid
	}

	public void updateSeller(String id, User seller) {
		if (!seller.valid())
			return;
		
		if (!sellers.containsKey(id))
			return;
		
		sellers.put(id, seller);
	}
	
	public void deleteSeller(String id) {
		
	}

	public Collection<User> getAllBuyers() {
		return Collections.unmodifiableCollection(buyers.values()); //TODO make it more solid
	}

	public User getBuyer(String id) {
		return buyers.get(id);
	}

	public void addBuyer(User buyer) {
		if(!buyer.valid())
			return;
		
		buyers.put(buyer.getId(), buyer);		
	}

	public void updateBuyer(String id, User buyer) {
		if (!buyer.valid())
			return;
		
		if (!buyers.containsKey(id))
			return;
		
		buyers.put(id,  buyer);
	}

	public List<Bid> getAllBids() {
		return null;
	}

	public ProjectDetail getProjectBids(String projectId) {
		
		BidQueue bidQ = proToBidQ.get(projectId);
		
		if (bidQ == null)
			return null;
		
		ProjectDetail pd = new ProjectDetail();
		Project project = this.getProject(projectId);
		List<Bid> allBids = bidQ.getBelowMinBids();
		
		pd.setProject(project);
		pd.setBids(allBids);
		return pd;
	}
}
