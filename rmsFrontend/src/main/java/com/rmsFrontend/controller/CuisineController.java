package com.rmsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuisine")
public class CuisineController {

	@RequestMapping("/showForm")
	public String showCuisine() {
		return "Cuisine";
	}
	
}
