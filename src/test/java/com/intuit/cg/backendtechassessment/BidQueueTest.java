package com.intuit.cg.backendtechassessment;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.intuit.cg.backendtechassessment.bid.Bid;
import com.intuit.cg.backendtechassessment.repository.BidQueue;

public class BidQueueTest {
	
	@Test
	public void addBid1() {
		
		Bid b1 = new Bid();
		b1.setId("123");
		b1.setBidAmount(50);
		
		Bid b2 = new Bid();
		b2.setId("456");
		b2.setBidAmount(40);
		
		Bid b3 = new Bid();
		b3.setId("789");
		b3.setBidAmount(100);
		
		Bid b4 = new Bid();
		b4.setId("345");
		b4.setBidAmount(25);
		
		BidQueue queue = new BidQueue();
		queue.addBid(b1);
		queue.addBid(b2);
		queue.addBid(b3);
		queue.addBid(b4);
		
		Bid min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 25);
		
	}
	
	@Test
	public void crudBid1() {
		
		Bid b1 = new Bid();
		b1.setId("123");
		b1.setBidAmount(50);
		
		Bid b2 = new Bid();
		b2.setId("456");
		b2.setBidAmount(40);
		
		Bid b3 = new Bid();
		b3.setId("789");
		b3.setBidAmount(100);
		
		BidQueue queue = new BidQueue();
		queue.addBid(b1);
		queue.addBid(b2);
		queue.addBid(b3);
		
		Bid min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 40);
		
		//-------------------------------------------------------
		
		queue.removeBid(b2);
		min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 50);
		
		//--------------------------------------------------------
		
		Bid b4 = new Bid();
		b4.setId("345");
		b4.setBidAmount(25);
		
		queue.addBid(b4);
		
		min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 25);
	}
	
	@Test
	public void curdBid2() {
		
		BidQueue queue = new BidQueue();
		
		Bid b1 = new Bid();
		b1.setId("123");
		b1.setBidAmount(50);
		
		queue.addBid(b1);
		
		Bid b2 = new Bid();
		b2.setId("123");
		b2.setBidAmount(40);
		
		queue.addBid(b2);
		
		Bid min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 40);
	}
	
	@Test
	public void curdBid3() {
		
		BidQueue queue = new BidQueue();
		
		Bid b1 = new Bid();
		b1.setId("123");
		b1.setBidAmount(50);
		
		queue.addBid(b1);
		
		Bid b2 = new Bid();
		b2.setId("456");
		b2.setBidAmount(40);
		
		queue.addBid(b2);
		
		Bid min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 40);
		
		b1.setBidAmount(10);
		
		queue.updateBid(b1);
		
		min = queue.min();
		
		assertNotNull(min);
		assertTrue(min.getBidAmount() == 10);
	}
	
	@Ignore
	@Test
	public void addEqualBid() {
		
		Bid b1 = new Bid();
		b1.setId("123");
		b1.setBidAmount(50);
		
		Bid b2 = new Bid();
		b2.setId("123");
		b2.setBidAmount(50);
		
		BidQueue queue = new BidQueue();
		queue.addBid(b1);
		queue.addBid(b2);
		
		Bid min = queue.min();
		
		assertNotNull(min);
		//assertTrue(min.getBidAmount() == 40);
		
	}

}
