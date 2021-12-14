package br.projeto.webform.service;

import br.projeto.webform.entity.Pessoa;

import java.util.Optional;

public interface PessoaService {
    String save(Pessoa model);

    Iterable<Pessoa> findAll();

    Optional<Pessoa> findById(Integer id);

    String delete(Integer id);
}
