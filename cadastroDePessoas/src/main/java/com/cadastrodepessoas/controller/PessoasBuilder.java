package com.cadastrodepessoas.controller;

import com.cadastrodepessoas.dto.PessoaDto;
import com.cadastrodepessoas.enums.NaturalidadeEnum;
import com.cadastrodepessoas.enums.SexoEnum;
import java.time.LocalDate;

public class PessoasBuilder {

    private final PessoaDto pessoa;

    public PessoasBuilder() {
        this.pessoa = new PessoaDto();
        this.pessoa.setDataDeInclusao(LocalDate.now());
    }

    public PessoasBuilder setNome(String nome) {
        this.pessoa.setNome(nome);
        return this;
    }

    public PessoasBuilder setSexo(SexoEnum sexo) {
        this.pessoa.setSexo(sexo);
        return this;
    }

    public PessoasBuilder setEmail(String email) {
        this.pessoa.setEmail(email);
        return this;
    }

    public PessoasBuilder setDataDeNascimento(LocalDate dataDeNascimento) {
        this.pessoa.setDataDeNascimento(dataDeNascimento);
        return this;
    }

    public PessoasBuilder setNaturalidade(NaturalidadeEnum naturalidade) {
        this.pessoa.setNaturalidade(naturalidade);
        return this;
    }

    public PessoasBuilder setNacionalidade(String nacionalidade) {
        this.pessoa.setNacionalidade(nacionalidade);
        return this;
    }

    public PessoasBuilder setCpf(String cpf) {
        this.pessoa.setCpf(cpf);
        return this;
    }

    public PessoaDto build() {
        return pessoa;
    }
}
