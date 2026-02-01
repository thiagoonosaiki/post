package com.example.post.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aereo")
public class AereoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cia;
    private String localizador;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCia() {
        return cia;
    }

    public void setCia(String cia) {
        this.cia = cia;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public SolicitacaoEntity getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(SolicitacaoEntity solicitacao) {
        this.solicitacao = solicitacao;
    }

    public List<AereoSeguimentoEntity> getSeguimentos() {
        return seguimentos;
    }

    public void setSeguimentos(List<AereoSeguimentoEntity> seguimentos) {
        this.seguimentos = seguimentos;
    }

    @OneToMany(mappedBy = "aereo", cascade = CascadeType.ALL)
    private List<AereoSeguimentoEntity> seguimentos = new ArrayList<>();
}
