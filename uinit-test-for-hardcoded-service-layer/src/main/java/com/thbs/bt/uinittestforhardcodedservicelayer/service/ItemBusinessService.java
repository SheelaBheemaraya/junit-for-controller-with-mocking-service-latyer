package com.thbs.bt.uinittestforhardcodedservicelayer.service;

import org.springframework.stereotype.Component;

import com.thbs.bt.uinittestforhardcodedservicelayer.model.Item;

@Component
public class ItemBusinessService {

	public Item retreiveHardcodedItem() {
		return new Item(1,"ball",10,100);
	}
	

}
