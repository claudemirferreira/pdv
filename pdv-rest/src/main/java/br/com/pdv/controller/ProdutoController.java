package br.com.pdv.controller;

import java.util.List;

import br.com.pdv.dto.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.pdv.dto.ProdutoDTO;
import br.com.pdv.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<ProdutoDTO> lista = service.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> findId(@PathVariable(value = "id") String id) {
        ProdutoDTO dto = service.findId(new Long(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        service.delete(new Long(id));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO dto) {
        dto = service.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO dto) {
        dto = service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}