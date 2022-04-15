package br.com.desafioapimongo.desafioapi.service.impl;

import br.com.desafioapimongo.desafioapi.model.Funcionario;
import br.com.desafioapimongo.desafioapi.repository.FuncionarioRepository;
import br.com.desafioapimongo.desafioapi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe = this.funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente!"));

        funcionario.setChefe(chefe);

        return this.funcionarioRepository.save(funcionario);
    }
}
