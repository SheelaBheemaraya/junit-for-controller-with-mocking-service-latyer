package com.thbs.bt.uinittestforhardcodedservicelayer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.bt.uinittestforhardcodedservicelayer.model.Item;
import com.thbs.bt.uinittestforhardcodedservicelayer.service.ItemBusinessService;



@RestController
public class ItemController {
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinessService() {
		Item item = businessService.retreiveHardcodedItem();
		
		return item;
	}

}
