package br.com.pdv.controller;

import java.awt.print.Pageable;
import java.util.List;

import br.com.pdv.controller.param.ProdutoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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

    @GetMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ProdutoDTO>> listar() {
        List<ProdutoDTO> lista = service.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping(
            value = "/filter",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity listarComFiltros(
            @RequestParam(name = "nome", required = false) final String nome,
            @RequestParam(name = "codigoBarra", required = false) final String codigoBarra,
            @RequestParam(name = "page", required = false) final Integer page,
            @RequestParam(name = "size", required = false) final Integer size) {

        ProdutoFilter filter = new ProdutoFilter(nome, codigoBarra);

        return new ResponseEntity<>(service.filter(filter, page, size), HttpStatus.OK);
    }

    @GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> findId(@PathVariable(value = "id") String id) {
        ProdutoDTO dto = service.findId(new Long(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO dto, BindingResult bindingResult) {
        dto = service.save(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoDTO> update(@RequestBody ProdutoDTO dto) {
        dto = service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}