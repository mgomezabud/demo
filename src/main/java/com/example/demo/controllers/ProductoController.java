package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Producto;
import com.example.demo.exceptions.RegistroNoExistenteException;
import com.example.demo.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@PostMapping
	public void guardar(@RequestBody Producto producto) {
		this.productoRepository.save(producto);
	}
	
	@GetMapping
	public List<Producto> consultar() {
		return this.productoRepository.findAll();
	}
	
	@GetMapping("/{codigo}/")
	public Producto consultarxCodigo(@PathVariable String codigo) {
		return this.productoRepository.findById(codigo)
				.orElseThrow(() -> new RegistroNoExistenteException("PRODUCTO_NO_ENCONTRADO"));
	}

}