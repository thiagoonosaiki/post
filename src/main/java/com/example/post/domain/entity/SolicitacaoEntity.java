package com.example.post.domain.entity;

import com.example.post.domain.StatusSolicitacaoEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa uma solicitaçã ode viagem.
 *
 * Atua como raiz do agregado, concentrando as informações
 * principais da solicitacao, seus passageiros e dados aéreos.
 */
@Entity
@Table(name = "solicitacao")
public class SolicitacaoEntity {

    /**
     * Identificador da solicitação.
     *
     * O valor é proveniente do sistema externo (SOAP)
     * sendo utilizado como chave primária.
     */
    @Id
    private int idSolicitacao;

    /**
     * Status atual da solicitação.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusSolicitacaoEntity status;

    /**
     * Nome do solicitante da viagem.
     */
    @Column(name = "solicitante")
    private String solicitante;

    /**
     * lista de passageiros associados à solicitação.
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    private List<PassageiroEntity> passageiros = new ArrayList<>();

    /**
     * Lista de informações aéreas associadas á solciitação.
     */
    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL)
    private List<AereoEntity> aereos = new ArrayList<>();

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public StatusSolicitacaoEntity getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacaoEntity status) {
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
}
