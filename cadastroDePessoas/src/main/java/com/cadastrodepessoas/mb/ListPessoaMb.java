package com.cadastrodepessoas.mb;

import com.cadastrodepessoas.dto.PessoaDto;
import com.cadastrodepessoas.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class ListPessoaMb implements Serializable {

    private List<PessoaDto> pessoas;

    @PostConstruct
    public void init() {
        System.out.println("Bean LisPessoaMb executado! ");
        pessoas = (List<PessoaDto>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaDePessoas");
    }

    public List<PessoaDto> getPessoas() {
        return pessoas;
    }

    public void redirecionaParaCadastro() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaDePessoas", pessoas);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("../create/createPessoa.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListPessoaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(PessoaDto pessoaARemover) {
        pessoas.remove(pessoaARemover);
        FacesUtil.addInfoMessage("Cadastro removido com sucesso!");
    }

    public void cadastrar() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("isRegister");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaAEditar");
        redirecionaParaCadastro();
    }

    public void edit(PessoaDto pessoaAEditar) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("isRegister", Boolean.FALSE);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoaAEditar", pessoaAEditar);
        redirecionaParaCadastro();
    }
}
