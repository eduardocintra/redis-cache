package br.com.eduardocintra.rediscache.domain.service;

import br.com.eduardocintra.rediscache.domain.model.Pessoa;
import br.com.eduardocintra.rediscache.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    public List<Pessoa> listar() {

        System.out.println("[LOG] => Serviço método listar() chamado!!!!!");
        return this.repository.findAll();
    }

    public Optional<Pessoa> buscarPor(Long id) {
        System.out.println("[LOG] => Serviço método buscarPor() chamado!!!!!");
        return this.repository.findById(id);
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        System.out.println("[LOG] => Serviço método salvar() chamado!!!!!");
        return this.repository.save(pessoa);
    }
}
