package br.com.desafioapimongo.desafioapi.service;

import br.com.desafioapimongo.desafioapi.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criarChefe (Funcionario funcionario);

    public Funcionario criarFuncionario (Funcionario funcionario);

    public void deletarPorCodigo (String codigo);

    public Funcionario atualizarPorId(Funcionario funcionario, String codigo);
}
