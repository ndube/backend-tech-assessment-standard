package com.intuit.cg.backendtechassessment.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;

@RestController
public class SellerController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(RequestMappings.SELLERS)
	public Collection<User> getAllSeller(){
		return userService.getAllSellers();
	}
	
	@RequestMapping(RequestMappings.SELLERS + "/{id}")
	public User getSeller(@PathVariable String id){
		return userService.getSeller(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value=RequestMappings.SELLERS)
	public void addSeller(@RequestBody User seller){
		userService.addSeller(seller);
	}

	@RequestMapping(method=RequestMethod.PUT, value=RequestMappings.SELLERS + "/{id}")
	public void updateSeller(@RequestBody User seller, @PathVariable String id){
		userService.updateSeller(id, seller);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=RequestMappings.SELLERS + "/{id}")
	public void deleteSeller(@PathVariable String id){
		userService.deleteSeller(id);
	}
	
}
