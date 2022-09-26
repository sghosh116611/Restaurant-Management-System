package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public List<Item> findAll() {
		return itemService.findAll();
	}

}
