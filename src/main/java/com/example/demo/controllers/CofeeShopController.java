package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CofeeShopController {

	@GetMapping("/hola/{nombre}")
	public String saludar(@PathVariable String nombre) {
		return "Hola " + nombre + System.currentTimeMillis();
	}

	@PostMapping("/hola/{nombre}")
	public String guardar(@PathVariable String nombre) {
		return "Hola " + nombre + System.currentTimeMillis();
	}

}