package com.thbs.bt.uinittestforhardcodedservicelayer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.thbs.bt.uinittestforhardcodedservicelayer.controller.ItemController;
import com.thbs.bt.uinittestforhardcodedservicelayer.model.Item;
import com.thbs.bt.uinittestforhardcodedservicelayer.service.ItemBusinessService;


@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
		
	
	@Test
	public void itemFromBusinessService_basic() throws Exception {
		when(businessService.retreiveHardcodedItem()).thenReturn(
				new Item(2,"Item2",10,10));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}"))
				.andReturn();
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
	}

}
