package br.com.pdv.controller;

import java.util.List;

import br.com.pdv.dto.ProdutoVendaDTO;
import br.com.pdv.model.entity.ProdutoVenda;
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

import br.com.pdv.dto.VendaDTO;
import br.com.pdv.service.VendaService;

@RestController
@RequestMapping("vendas/")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VendaDTO>> listar() {
        List<VendaDTO> lista = service.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaDTO> findId(@PathVariable(value = "id") String id) {
        VendaDTO dto = service.findId(new Long(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
        service.delete(new Long(id));
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaDTO> save(@RequestBody VendaDTO dto) {
        List<ProdutoVendaDTO> lista = dto.getProdutoVendas();
        dto = service.save(dto);
        dto.setProdutoVendas(lista);
        service.salvarProdutos(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VendaDTO> update(@RequestBody VendaDTO dto) {
        dto = service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}