package com.cadastrodepessoas.dto;

import com.cadastrodepessoas.enums.NaturalidadeEnum;
import com.cadastrodepessoas.enums.SexoEnum;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PessoaDto {

    private String nome; //obrigatório
    private SexoEnum sexo;
    private String email;// - não obrigatório, deve ser validado caso preenchido
    private LocalDate dataDeNascimento; // obrigatório, deve ser validada
    private NaturalidadeEnum naturalidade;
    private String nacionalidade;
    private String cpf;//obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
    private LocalDate dataDeInclusao; // obrigatório, deve ser validada
    private LocalDate dataDeUltimaAtualizacao; // obrigatório, deve ser validada

    public PessoaDto() {
    }

    public PessoaDto(String nome, SexoEnum sexo, String email, LocalDate dataDeNascimento,
            NaturalidadeEnum naturalidade, String nacionalidade, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getDataDeNascimentoFromatada() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDeNascimento.format(formatador);
    }

    public NaturalidadeEnum getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(NaturalidadeEnum naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeInclusao() {
        return dataDeInclusao;
    }

    public void setDataDeInclusao(LocalDate dataDeInclusao) {
        this.dataDeInclusao = dataDeInclusao;
    }

    public LocalDate getDataDeUltimaAtualizacao() {
        return dataDeUltimaAtualizacao;
    }

    public void setDataDeUltimaAtualizacao(LocalDate dataDeUltimaAtualizacao) {
        this.dataDeUltimaAtualizacao = dataDeUltimaAtualizacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaDto other = (PessoaDto) obj;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", dataDeNascimento=" + dataDeNascimento + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", cpf=" + cpf + '}';
    }
}
