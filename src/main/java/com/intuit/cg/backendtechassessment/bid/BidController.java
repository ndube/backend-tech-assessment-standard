package com.intuit.cg.backendtechassessment.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.cg.backendtechassessment.controller.requestmappings.RequestMappings;

@RestController
public class BidController {
	
	@Autowired
	private BidService bidService;
	
	@RequestMapping(method=RequestMethod.POST, value=RequestMappings.BIDS)
	public String addBid(@RequestBody Bid bid) {
		return bidService.addBid(bid);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value=RequestMappings.BIDS + "/{id}")
	public void updateBid(@RequestBody Bid bid, @PathVariable String id) {
		bidService.updateBid(id, bid);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=RequestMappings.BIDS + "/{id}")
	public void deleteBid(@PathVariable String id) {
		bidService.deleteBid(id);
	}

}
