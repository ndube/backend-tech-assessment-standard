package com.intuit.cg.backendtechassessment.user;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intuit.cg.backendtechassessment.repository.RepoManager;

@Service
public class UserService {

	public Collection<User> getAllSellers() {
		return RepoManager.getAllSellers();
	}
	
	public User getSeller(String id) {
		return RepoManager.getSeller(id);
	}

	public void addSeller(User seller) {
		RepoManager.addSeller(seller);
	}

	public void updateSeller(String id, User seller) {
		RepoManager.updateSeller(id, seller);
	}

	public void deleteSeller(String id) {
		RepoManager.deleteSeller(id);
	}

	public Collection<User> getAllBuyers() {
		return RepoManager.getAllBuyers();
	}

	public User getBuyer(String id) {
		return RepoManager.getBuyer(id);
	}

	public void addBuyer(User buyer) {
		RepoManager.addBuyer(buyer);
	}

	public void updateBuyer(String id, User buyer) {
		RepoManager.updateBuyer(id, buyer);
	}

	public void deleteBuyer(String id) {
		
	}

}
