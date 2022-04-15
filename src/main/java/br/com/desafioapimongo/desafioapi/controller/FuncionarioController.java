package br.com.desafioapimongo.desafioapi.controller;

import br.com.desafioapimongo.desafioapi.model.Funcionario;
import br.com.desafioapimongo.desafioapi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {

        return this.funcionarioService.obterTodos();

    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {

        return this.funcionarioService.obterPorCodigo(codigo);

    }

    @PostMapping("/criarFuncionario")
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario) {

        return this.funcionarioService.criarFuncionario(funcionario);

    }

    @PostMapping("/criarChefe")
    public Funcionario criarChefe(@RequestBody Funcionario funcionario) {

        return this.funcionarioService.criarChefe(funcionario);

    }

    @DeleteMapping("/{codigo}")
    public void deletarPorCodigo(@PathVariable String codigo) {

        this.funcionarioService.deletarPorCodigo(codigo);

    }

    @PutMapping("/{codigo}")
    public Funcionario AtualizarPorCodigo(@RequestBody Funcionario funcionario, @PathVariable String codigo) {

        return this.funcionarioService.atualizarPorId(funcionario, codigo);

    }

}
