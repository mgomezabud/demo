package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private List<Producto> productos = new ArrayList<>(Arrays.asList(new Producto("a","a",1D), new Producto("b","b",2D)));

	@PostMapping
	public void guardar(@RequestBody Producto producto) {
		productos.add(producto);
	}
	
	@GetMapping
	public List<Producto> consultar() {
		return this.productos;
	}
	
	@GetMapping("/{codigo}/")
	public Producto consultarxCodigo(@PathVariable String codigo) {
		return this.productos.stream()
		.filter(p -> p.getCodigo().matches(codigo))
		.findAny().orElseThrow(() -> new RuntimeException(""));
	}

}