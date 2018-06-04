package com.intuit.cg.backendtechassessment.project;

import java.util.List;

import com.intuit.cg.backendtechassessment.bid.Bid;

public class ProjectDetail {
	
	private Project project;
	private List<Bid> bids;
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	
	

}
