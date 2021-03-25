package br.fatec.financas2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.financas2021.model.Conta;
import br.fatec.financas2021.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController implements ControllerInterface<Conta> {
    
    @Autowired
    private ContaService service;

    @Override
    @GetMapping
    public ResponseEntity<List<Conta>> getAll() {
        return ResponseEntity.ok(service.FindAll());
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        Conta _conta = service.FindById(id);
        if (_conta != null) {
            return ResponseEntity.ok(_conta);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Conta> post(@RequestBody Conta conta) {
        service.create(conta);
        return ResponseEntity.ok(conta);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> put(@RequestBody Conta conta) {
        if (service.update(conta)) {
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
