package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;

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

import com.soumojitghoshspring.rmsBackend.entity.Cuisine;
import com.soumojitghoshspring.rmsBackend.service.intrface.CuisineService;

@RestController
@RequestMapping("/api")
public class CuisineRestController {

	@Autowired
	CuisineService cuisineService;
	
	@GetMapping("/cuisines")
	public List<Cuisine> findAll(){
		return cuisineService.findAll();
	}
	
	@GetMapping("/cuisines/{cuisineId}")
	public Cuisine getCuisine(@PathVariable int cuisineId) {
		return cuisineService.findCuisine(cuisineId);
	}
	
	@PostMapping("/cuisines")
	public ResponseEntity<Cuisine> save(@RequestBody Cuisine cuisine) {
		cuisineService.save(cuisine);
		return new ResponseEntity<>(cuisine,HttpStatus.OK);
	}
	
	@PutMapping("/cuisines")
	public ResponseEntity<Cuisine> update(@RequestBody Cuisine cuisine){
		cuisineService.save(cuisine);
		return new ResponseEntity<>(cuisine,HttpStatus.OK);
	}
	
	@DeleteMapping("/cuisines/{cuisineId}")
	public ResponseEntity<String> delete(@PathVariable int cuisineId){
		cuisineService.delete(cuisineId);
		return new ResponseEntity<>("Item deleted with id:"+cuisineId,HttpStatus.OK);
	}
	
}
