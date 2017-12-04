package br.com.pdv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.service.ProdutoService;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProdutoDTO>> listar() {
		List<ProdutoDTO> lista = service.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProdutoDTO> findOne(@PathVariable(value = "id") String id) {
		ProdutoDTO dto = service.findId(new Long(id));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
