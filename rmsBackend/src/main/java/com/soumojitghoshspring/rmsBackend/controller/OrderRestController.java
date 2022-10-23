package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumojitghoshspring.rmsBackend.entity.Order;
import com.soumojitghoshspring.rmsBackend.service.intrface.OrderService;

@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getAll(){
		return orderService.getAll();
	}
	
	@GetMapping("/orders/{orderId}")
	public Order get(@PathVariable int orderId){
		return orderService.get(orderId);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> save(@RequestBody Order order){
		orderService.save(order);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
}
