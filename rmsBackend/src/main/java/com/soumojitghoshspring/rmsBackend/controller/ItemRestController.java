package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public List<Item> findAll(
			@RequestParam(name="sort",required = false) Optional<List<String>> sort, 
			@RequestParam(defaultValue="desc") String order ) {
		return itemService.findAll(sort,order);
	}

	@GetMapping("/items/{itemId}")
	public Item findItem(@PathVariable int itemId) {
		return itemService.findItem(itemId);
	}

	@PostMapping("/items")
	public ResponseEntity<Item> save(@RequestBody Item item) {
		itemService.save(item);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@PutMapping("/items")
	public ResponseEntity<Item> update(@RequestBody Item item) {
		itemService.save(item);
		return new ResponseEntity<>(item, HttpStatus.OK);
	}

	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<String> delete(@PathVariable int itemId) {
		itemService.delete(itemId);
		return new ResponseEntity<>("Deleted item with id : " + itemId, HttpStatus.OK);
	}

}
