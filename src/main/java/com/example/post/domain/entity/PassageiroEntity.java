package com.example.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Entidade que representa um passageiro associado
 * a uma solciitação de viagem.
 */
@Entity
@Table(name = "passageiro")
public class PassageiroEntity {

    /**
     * IDentificar único do passageiro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do passageiro.
     */
    private String nome;

    /**
     * Solicitação à qual o passageiro está associado.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;

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
}
