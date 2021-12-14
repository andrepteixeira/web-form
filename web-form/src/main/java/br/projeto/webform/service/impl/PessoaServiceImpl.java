package br.projeto.webform.service.impl;

import br.projeto.webform.entity.Pessoa;
import br.projeto.webform.repository.PessoaRepository;
import br.projeto.webform.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    protected Environment env;

    @Override
    public String save(Pessoa pessoa) {
        if (Objects.nonNull(pessoa)){
            repository.save(pessoa);
            return this.env.getProperty("message.success");
        }
        return this.env.getProperty("message.error.invalid");
    }

    @Override
    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pessoa> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public String delete(Integer id) {
        Optional<Pessoa> optionalPessoa = repository.findById(id);
        if (optionalPessoa.isPresent()){
            repository.delete(optionalPessoa.get());
            return this.env.getProperty("message.success");
        }
        return this.env.getProperty("message.error.notfound");
    }
}
