package br.projeto.webform.controller;

import br.projeto.webform.entity.Pessoa;
import br.projeto.webform.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE,
        RequestMethod.OPTIONS }, origins = "*")
@RestController
@RequestMapping("${pessoa.servlet.path}")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping()
    public @ResponseBody Object create(@RequestBody Pessoa pessoa) {
        return service.save(pessoa);
    }

    @GetMapping()
    public @ResponseBody Iterable<Pessoa> getAll() {
        return service.findAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Pessoa getOne(@PathVariable Integer id) {
        return service.findById(id).get();
    }

    @PutMapping(path = "{id}")
    public @ResponseBody Object update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
        if (pessoa.getId() == null) {
            pessoa.setId(id);
        }
        return service.save(pessoa);

    }

    @DeleteMapping(path = "{id}")
    public @ResponseBody
    String deleteBlog(@PathVariable Integer id) {
        return service.delete(id);
    }
}
