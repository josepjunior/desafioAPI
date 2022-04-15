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
    public List<Funcionario> obterTodos(){

        return this.funcionarioService.obterTodos();

    }

    @GetMapping ("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo){

        return this.funcionarioService.obterPorCodigo(codigo);

    }

    @PostMapping
    public Funcionario criar (@RequestBody Funcionario funcionario){

        return this.funcionarioService.criar(funcionario);

    }


}
