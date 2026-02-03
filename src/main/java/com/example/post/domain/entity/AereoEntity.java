package com.example.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade que representa as informações aéreas
 * associadas a uma solicitação de viagem.
 *
 * Contém dados da companhia aérea, localizador
 * e seus respectivos segmentos de voo.
 */
@Entity
@Table(name = "aereo")
public class AereoEntity {

    /**
     * Identificador único do registro aéreo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Companhia aérea validadora.
     */
    private String cia;

    /**
     * Código localizador da reserva aérea.
     */
    private String localizador;

    /**
     * Solicitação à qual este registro aéreo pertence.
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    private SolicitacaoEntity solicitacao;

    /**
     * Segmentos de voo associados ao registro aéreo.
     */
    @OneToMany(mappedBy = "aereo", cascade = CascadeType.ALL)
    private List<AereoSeguimentoEntity> seguimentos = new ArrayList<>();

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
}
