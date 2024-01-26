package com.rishabhtech.rsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByController {

	@GetMapping("/bye")
	public String sayBye() {
		return "Bye";
	}
}
