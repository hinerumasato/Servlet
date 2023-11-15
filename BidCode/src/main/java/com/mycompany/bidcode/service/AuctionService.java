package com.mycompany.bidcode.service;

import com.mycompany.bidcode.model.AuctionItem;
import com.mycompany.bidcode.model.User;
import java.util.Collection;

public class AuctionService {
	private AuctionDatabase database;
	
	public AuctionService() {
		database = AuctionDatabase.getInstance();
	}
	
	public Collection<AuctionItem> getAllAuctionItems(){
		return database.getAllAuctionItems();
	}
	
	public AuctionItem getAuctionItem(Long id){
		return database.getAuctionItem(id);
	}
	
	public User authenticateUser(String name, String password){
		return database.authenticateUser(name, password);
	}
	
	public void bid(User user, AuctionItem item, double amount){
		item.bid(user, amount);
	}
}
