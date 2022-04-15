package br.com.desafioapimongo.desafioapi;


import br.com.desafioapimongo.desafioapi.model.Funcionario;
import br.com.desafioapimongo.desafioapi.repository.FuncionarioRepository;
import br.com.desafioapimongo.desafioapi.service.impl.FuncionarioServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class FuncionarioTest {

    @TestConfiguration
    static class FuncionarioServiceTestConfiguration{

        @Bean
        public FuncionarioServiceImpl funcionarioServiceImpl(){

            return new FuncionarioServiceImpl();

        }

    }

    @Autowired
    FuncionarioServiceImpl funcionarioServiceImp;

    @MockBean
    FuncionarioRepository funcionarioRepository;

    @Before
    public void setup(){

        Funcionario funcionarioChefeModel = new Funcionario();

        funcionarioChefeModel.setCodigo("a1234");
        funcionarioChefeModel.setNome("José chefe");
        funcionarioChefeModel.setIdade(30);
        funcionarioChefeModel.setSalario(BigDecimal.valueOf(3000));


        Funcionario funcionarioModel = new Funcionario();
        funcionarioModel.setCodigo("b1234");
        funcionarioModel.setNome("José funcionario");
        funcionarioModel.setIdade(30);
        funcionarioModel.setSalario(BigDecimal.valueOf(1500));
        funcionarioModel.setChefe(funcionarioChefeModel);

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(funcionarioChefeModel);
        funcionarios.add(funcionarioModel);

        Mockito.when(funcionarioRepository.findAll())
                        .thenReturn(funcionarios);

        Mockito.when(funcionarioRepository.findById(funcionarioModel.getCodigo()))
                .thenReturn(Optional.of(funcionarioModel));

    }

    @Test
    public void TesteFuncionarioMenorDeIdade (){

        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        boolean flag = false;

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getIdade()<18) flag = true;

        }

        Assertions.assertEquals(false,flag);

    }

}
