package br.com.desafioapimongo.desafioapi.repository;

import br.com.desafioapimongo.desafioapi.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FuncionarioRepository extends MongoRepository <Funcionario, String> {


}
