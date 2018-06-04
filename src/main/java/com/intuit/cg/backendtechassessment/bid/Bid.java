package com.intuit.cg.backendtechassessment.bid;

import java.util.Date;

public class Bid implements Comparable<Bid>{
	
	private String projectId;
	private double bidAmount;
	private String bidderId;
	private Date bidLastUpdatedOn;
	private String id;
	private BidStatus bidStatus = BidStatus.IN_PROGRESS;
	
	
	public String getProjectId() {
		return projectId;
	}
	public void setProject(String projectId) {
		this.projectId = projectId;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getBidderId() {
		return bidderId;
	}
	public void setBidder(String bidderId) {
		this.bidderId = bidderId;
	}
	public Date getBidLastUpdatedOn() {
		return bidLastUpdatedOn;
	}
	public void setBidLastUpdatedOn(Date bidCreatedOn) {
		this.bidLastUpdatedOn = bidCreatedOn;
	}
	
	public String getId() {
		if (this.id == null) {
			this.id = projectId+bidderId;
		}
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public BidStatus getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}
	@Override
	public boolean equals(Object that) {
		
		if (that == null)
			return false;
		
		if (that instanceof Bid) {
			
			Bid thatBid = (Bid)that;
			
			return this.getId().equals(thatBid.getId());
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Bid o) {
		
		if (o == null) {
			return 1;
		}
		
		if (this.bidAmount == o.bidAmount)
			return 0;
		else if (this.bidAmount > o.bidAmount)
			return 1;
		else
			return -1;
	}
	
	public Bid copy() {
		Bid copy = new Bid();
		copy.setBidAmount(this.getBidAmount());
		copy.setBidLastUpdatedOn(this.getBidLastUpdatedOn());
		copy.setBidder(this.getBidderId()); //TODO set the copy of the Bidder, not the actual bidder
		copy.setId(this.getId());
		copy.setProject(this.getProjectId()); //TODO set the copy of the Project, not the actual project
		copy.setBidStatus(this.getBidStatus());
		return copy;
	}
	
}
