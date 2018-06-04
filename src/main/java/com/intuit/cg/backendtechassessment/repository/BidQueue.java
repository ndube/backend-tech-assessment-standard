package com.intuit.cg.backendtechassessment.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intuit.cg.backendtechassessment.bid.Bid;
import com.intuit.cg.backendtechassessment.bid.BidStatus;

public final class BidQueue {
	
	private Map<String, Integer> bidMap = new HashMap<>();
	private Bid[] bids = new Bid[1];
	private int heapSize;
	
	public synchronized Bid min() {
		if (heapSize == 0)
			return null;
		
		return bids[0].copy();
	}
	
	public synchronized void addBid(Bid bid) {
		
		if (bidMap.containsKey(bid.getId())) {
			updateBid(bid);
			return;
		}
		
		if (heapSize == bids.length) {
			resizeHeap(2*heapSize);
		}
		
		bids[heapSize] = bid;
		
		int curr = heapSize;
		int parent = curr/2;
		
		while(parent >= 0 && bid.compareTo(bids[parent]) < 0) {
			swap(parent, curr);
			curr = parent;
			parent = parent/2;
		}
		heapSize++;
		bidMap.put(bid.getId(), curr);
	}
	
	public synchronized void updateBid(Bid bid) {
		
		int bidIdx = -1;
		
		if (bidMap.containsKey(bid.getId()))
			bidIdx = bidMap.get(bid.getId());
		
		if (bidIdx == -1) {
			// Throw an exception
			return;
		}
		
		if (bid.getBidAmount() == bids[bidIdx].getBidAmount())
			return;
		
		if (bid.getBidAmount() > bids[bidIdx].getBidAmount())
			increaseBid(bidIdx, bid);
		else
			decreaseBid(bidIdx, bid);
	}
	
	public synchronized void removeBid(Bid bid) {
		
		if (heapSize <= bids.length/4) {
			resizeHeap(bids.length/2);
		}
		
		int bidIdx = -1;
		
		if (bidMap.containsKey(bid.getId()))
			bidIdx = bidMap.get(bid.getId());
		
		
		if (bidIdx == -1) {
			// Throw an exception
			return;
		}
		bid.setBidAmount(Double.MAX_VALUE);
		increaseBid(bidIdx, bid);
		bids[heapSize] = null;
		heapSize--;
		bidMap.remove(bid.getId());
	}

	private void decreaseBid(int key, Bid bid) {
		
		if (bids[key].getBidAmount() < bid.getBidAmount())
			return;
		
		if (key == 0) {
			bids[0] = bid;
			return;
		}
		
		int curr = key;
		int parent = curr/2;
		
		while(parent >= 0 && bid.compareTo(bids[parent]) < 0) {
			swap(parent, curr);
			curr = parent;
			parent = parent/2;
		}
		
		bidMap.put(bid.getId(), curr);
	}
	
	private void increaseBid(int key, Bid bid) {
		
		if (bids[key].getBidAmount() > bid.getBidAmount())
			return;
		
		bids[key] = bid;
		
		minHeapify(key, bid);
	}
	
	private void minHeapify(int key, Bid bid) {
		int smallest = key;
		int left = 2*key;
		int right = left+1;
		
		if (left<heapSize && bids[smallest].getBidAmount()> bids[left].getBidAmount())
			smallest = left;
		
		if (right<heapSize && bids[smallest].getBidAmount()> bids[right].getBidAmount())
			smallest = right;
		
		if (smallest != key) {
			swap(key, smallest);
			bidMap.put(bid.getId(), smallest);
			minHeapify(smallest, bid);
		}
	}

	private void swap(int parent, int curr) {
		Bid temp = bids[parent];
		bids[parent] = bids[curr];
		bids[curr] = temp;
	}

	private void resizeHeap(int capacity) {
		Bid[] copy = new Bid[capacity];
		Map<String, Integer> copyMap = new HashMap<>();
		
		for (int i=0; i<bids.length; i++) {
			copy[i] = bids[i];
			copyMap.put(bids[i].getId(), i);
		}
		
		bids = copy;
		bidMap = copyMap;
	}
	
	public List<Bid> getBelowMinBids(){
		
		List<Bid> bidList = new ArrayList<>();
		
		for (int i=1; i< heapSize; i++) {
			bidList.add(bids[i].copy());
		}
		return bidList;
	}

	public void updateBidStatus(BidStatus status) {
		for (int i=1; i<heapSize; i++) {
			bids[i].setBidStatus(status);
		}
	}

}
