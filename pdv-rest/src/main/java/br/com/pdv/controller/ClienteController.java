package br.com.pdv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pdv.dto.ClienteDTO;
import br.com.pdv.service.ClienteService;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteDTO>> listar() {
		List<ClienteDTO> lista = service.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> findId(@PathVariable(value = "id") String id) {
		ClienteDTO dto = service.findId(new Long(id));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
		service.delete(new Long(id));
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO dto) {
		dto = service.save(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteDTO> upfate(@RequestBody ClienteDTO dto) {
		dto = service.update(dto);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}