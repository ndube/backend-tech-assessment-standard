package com.intuit.cg.backendtechassessment.bid;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intuit.cg.backendtechassessment.repository.RepoManager;

@Service
public class BidService {

	public List<Bid> getAllBids() {
		return RepoManager.getAllBids();
	}

	public Bid getProjectBids(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String addBid(Bid bid) {
		return RepoManager.addBid(bid);
	}

	public void updateBid(String id, Bid bid) {
		RepoManager.updateBid(id, bid);
	}

	public void deleteBid(String id) {
		// TODO Auto-generated method stub
		
	}

}
