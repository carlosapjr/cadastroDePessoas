package com.cadastrodepessoas.controller;

import com.cadastrodepessoas.dto.PessoaDto;
import com.cadastrodepessoas.enums.NaturalidadeEnum;
import com.cadastrodepessoas.enums.SexoEnum;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PessoaFactory {
 
    public static List<PessoaDto> createPessoasExemplo(){
        List<PessoaDto> pessoasExemplo = new ArrayList<>();
        PessoaDto pessoaExemplo1 = new PessoasBuilder()
                .setNome("Pedro da Silva")
                .setCpf("999.999.999-99")
                .setSexo(SexoEnum.MASCULINO)
                .setDataDeNascimento(LocalDate.of(1999, Month.SEPTEMBER, 9))
                .setNaturalidade(NaturalidadeEnum.SANTA_CATARINA)
                .setNacionalidade("Brasileiro")
                .setEmail("pedro@compania.com")
                .build();
        
        PessoaDto pessoaExemplo2 = new PessoasBuilder()
                .setNome("Maria da Silveira")
                .setCpf("777.777.777-77")
                .setSexo(SexoEnum.FEMININO)
                .setDataDeNascimento(LocalDate.of(1977, Month.JULY, 7))
                .setNaturalidade(NaturalidadeEnum.SANTA_CATARINA)
                .setNacionalidade("Brasileira")
                .setEmail("maria@compania.com")
                .build();
        
        pessoasExemplo.add(pessoaExemplo1);
        pessoasExemplo.add(pessoaExemplo2);
        return pessoasExemplo;        
    }
}
