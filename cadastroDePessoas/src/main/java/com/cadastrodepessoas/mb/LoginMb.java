package com.cadastrodepessoas.mb;

import com.cadastrodepessoas.controller.PessoaFactory;
import com.cadastrodepessoas.util.FacesUtil;
import com.cadastrodepessoas.util.SessionUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class LoginMb implements Serializable {

    private String email;
    private String senha;

    @PostConstruct
    public void init() {
        System.out.println("Bean LoginMb executado! ");
    }

    public void autentica() {
        System.out.println("autentica..");

        if ((email.equals("admin") && senha.equals("admin"))
                ||(email.equals("123") && senha.equals("123"))) {
            System.out.println("Confirmou  usuario e senha ...");
            Object b = new Object();
            SessionUtil.setParam("USUARIOLogado", b);
            redirecionaParaListagem();
        }else{
            FacesUtil.addErrorMessage("Usuário não cadastrado ou usuário e senha não conferem!");
        }
    }

    public String registraSaida() {
        return "/Login?faces-redirect=true";
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void redirecionaParaListagem() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaDePessoas", PessoaFactory.createPessoasExemplo());
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("../list/listPessoa.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListPessoaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
