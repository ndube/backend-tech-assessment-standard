package com.intuit.cg.backendtechassessment.user;

import java.util.List;

import org.springframework.util.StringUtils;

import com.intuit.cg.backendtechassessment.bid.Bid;

public class User {
	
	private String id;
	private List<Bid> bids;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	@Override
	public boolean equals(Object that) {
		
		if (that == null)
			return false;
		
		if (that instanceof User) {
			
			User thatU = (User)that;
			
			return this.getId().equals(thatU.getId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
	public boolean valid() {
		
		if (StringUtils.isEmpty(id))
			return false;
		
		return this.id.matches("[^a-z A-Z0-9]");
	}

}
