package com.mendoza.denunciaservice.controller;

import com.mendoza.denunciaservice.entity.Denuncia;
import com.mendoza.denunciaservice.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService service;

    @GetMapping
    public ResponseEntity<List<Denuncia>> getAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);

        List<Denuncia> registros = service.getAll(page);
        return ResponseEntity.ok(registros);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Denuncia> get(@PathVariable("id") int id) {
        Denuncia denuncia = service.getById(id);
        if (denuncia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(denuncia);
    }

    @GetMapping(value = "/usuario/{dni}")
    public ResponseEntity<List<Denuncia>> getByDni(@PathVariable("dni") String dni) {
        List<Denuncia> registros = service.getAllByDni(dni);
        return ResponseEntity.ok(registros);
    }

    @PostMapping
    public ResponseEntity<Denuncia> create(@RequestBody Denuncia denuncia){
        Denuncia registro = service.create(denuncia);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Denuncia> update(@PathVariable("id") int id,@RequestBody Denuncia denuncia){
        denuncia.setId(id);
        Denuncia registro=service.update(denuncia);
        if(registro==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(registro);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Denuncia> delete(@PathVariable("id") int id){
        service.delete(id);
        return ResponseEntity.ok(null);
    }
}
