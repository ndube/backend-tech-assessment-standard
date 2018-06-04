package com.intuit.cg.backendtechassessment.project;

import java.util.Date;

import com.intuit.cg.backendtechassessment.bid.Bid;

public class Project {
	
	private String id;
	private String description;
	private Date bidDeadline;
	private String postedBy;
	private Bid lowestBid;
	
	public String getId() {
		return id;
	}
	public void setName(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBidDeadline() {
		return bidDeadline;
	}
	public void setBidDeadline(Date bidDeadline) {
		this.bidDeadline = bidDeadline;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public Bid getLowestBid() {
		return lowestBid;
	}
	public void setLowestBid(Bid lowestBid) {
		this.lowestBid = lowestBid;
	}
	
	@Override
	public boolean equals(Object that) {
		
		if (that == null)
			return false;
		
		if (that instanceof Project) {
			
			Project thatP = (Project)that;
			
			return this.getId().equals(thatP.getId())
					&& this.getPostedBy().equals(thatP.getPostedBy());
		}
		
		return false;
	}
	public void update(Project project) {

		if (project == null)
			return;
		
		this.setDescription(project.getDescription());
		this.setBidDeadline(project.getBidDeadline());
	}

}
