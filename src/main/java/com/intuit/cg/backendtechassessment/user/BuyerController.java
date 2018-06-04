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
public class BuyerController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(RequestMappings.BUYERS)
	public Collection<User> getAllBuyers(){
		return userService.getAllBuyers();
	}
	
	@RequestMapping(RequestMappings.BUYERS + "/{id}")
	public User getBuyer(@PathVariable String id){
		return userService.getBuyer(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value=RequestMappings.BUYERS)
	public void addBuyer(@RequestBody User buyer){
		userService.addBuyer(buyer);
	}

	@RequestMapping(method=RequestMethod.PUT, value=RequestMappings.BUYERS + "/{id}")
	public void updateBuyer(@RequestBody User buyer, @PathVariable String id){
		userService.updateBuyer(id, buyer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=RequestMappings.BUYERS + "/{id}")
	public void deleteBuyer(@PathVariable String id){
		userService.deleteBuyer(id);
	}
	
}
