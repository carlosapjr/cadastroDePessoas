package com.cadastrodepessoas.mb;

import com.cadastrodepessoas.dto.PessoaDto;
import com.cadastrodepessoas.enums.NaturalidadeEnum;
import com.cadastrodepessoas.enums.SexoEnum;
import com.cadastrodepessoas.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ViewScoped
@ManagedBean
public class CreatePessoaMb implements Serializable {

    private PessoaDto pessoa;
    private Boolean isRegister;
    private Date data;
    private List<PessoaDto> pessoas;
    private Date today;

    @PostConstruct
    public void init() {
        System.out.println(" Bean CreatePessoaMb executado! ");

        pessoa = new PessoaDto();
        today = Calendar.getInstance().getTime();
        pessoas = (List<PessoaDto>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaDePessoas");
        isRegister = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("isRegister");
        isRegister = Objects.nonNull(isRegister) ? isRegister : Boolean.TRUE;
        if (!isRegister) {
            pessoa = (PessoaDto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pessoaAEditar");
            data = Date.from(pessoa.getDataDeNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("listaDePessoas");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("pessoaAEditar");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("isRegister");
    }

    public PessoaDto getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDto pessoa) {
        this.pessoa = pessoa;
    }

    public NaturalidadeEnum[] getNaturalidade() {
        return NaturalidadeEnum.values();
    }

    public SexoEnum[] getSexo() {
        return SexoEnum.values();
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public Boolean getIsRegister() {
        return isRegister;
    }

    public Date getToday() {
        return today;
    }

    public String getMessage() {
        return "Hello CreatePessoaMb JSF!";
    }

    public void salvar() {
        pessoa.setDataDeNascimento(data.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        pessoa.setDataDeUltimaAtualizacao(LocalDate.now());

        if (isRegister) {
            pessoa.setDataDeInclusao(LocalDate.now());
            if (!pessoas.isEmpty()) {
                for (PessoaDto pessoaAtual : pessoas) {
                    if (pessoaAtual.equals(pessoa)) {
                        FacesUtil.addErrorMessage("CPF já cadastrado!");
                    }
                }
            }

            pessoas.add(pessoa);
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i).equals(pessoa)) {
                    pessoas.set(i, pessoa);
                }
            }
        }
        redirecionaParaListagem();
    }

    public void redirecionaParaListagem() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaDePessoas", pessoas);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("../list/listPessoa.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ListPessoaMb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
