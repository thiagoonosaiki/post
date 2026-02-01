package com.example.post.domain.entity;

import br.com.seuprojeto.soap.client.StatusSolicitacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "solicitacao")
public class SolicitacaoEntity {

    @Id
    private int idSolicitacao;

    private StatusSolicitacao status;

    private String solicitante;

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    private List<PassageiroEntity> passageiros = new ArrayList<>();

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public StatusSolicitacao getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public List<PassageiroEntity> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<PassageiroEntity> passageiros) {
        this.passageiros = passageiros;
    }

    public List<AereoEntity> getAereos() {
        return aereos;
    }

    public void setAereos(List<AereoEntity> aereos) {
        this.aereos = aereos;
    }

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    private List<AereoEntity> aereos = new ArrayList<>();
}
