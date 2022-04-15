package br.com.desafioapimongo.desafioapi.service;

import br.com.desafioapimongo.desafioapi.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar (Funcionario funcionario);
}