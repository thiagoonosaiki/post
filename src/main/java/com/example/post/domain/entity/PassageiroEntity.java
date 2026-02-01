package com.example.post.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passageiro")
public class PassageiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SolicitacaoEntity getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(SolicitacaoEntity solicitacao) {
        this.solicitacao = solicitacao;
    }

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;
}
