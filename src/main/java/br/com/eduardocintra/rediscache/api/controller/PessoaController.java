package br.com.eduardocintra.rediscache.api.controller;

import br.com.eduardocintra.rediscache.domain.model.Pessoa;
import br.com.eduardocintra.rediscache.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){

        System.out.println("[LOG] => método listar() foi chamado!!!");

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable("id") Long id){

        System.out.println("[LOG] => método buscarPorId() foi chamado!!!");

        Optional<Pessoa> optionalPessoa = service.buscarPor(id);
        if(!optionalPessoa.isPresent()) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(optionalPessoa.get());
    }

    @PostMapping
    public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa){

        System.out.println("[LOG] => método adicionar() foi chamado!!!");

        return ResponseEntity.ok(service.salvar(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa request, @PathVariable("id") Long id){

        System.out.println("[LOG] => método atualizar() foi chamado!!!");

        Optional<Pessoa> optionalPessoa = service.buscarPor(id);
        if(!optionalPessoa.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Pessoa pessoa = optionalPessoa.get();
        BeanUtils.copyProperties(request, pessoa, "id");

        return ResponseEntity.ok(service.salvar(pessoa));
    }
}
