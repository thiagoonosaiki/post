package com.example.post.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entidade que representa um segmento aéreo de uma viagem.
 *
 * Cada segmento está associado a um registro aéreo
 * e contém informações de origem, destino e datas.
 */
@Entity
@Table(name = "aereo_seguimento")
public class AereoSeguimentoEntity {

    /**
     * Identificador único do segmento aéreo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Cidade de origem do segmento.
     */
    @Column(name = "cidade_origem")
    private String cidadeOrigem;

    /**
     * Cidade de destino do segmento.
     */
    @Column(name = "cidade_destino")
    private String cidadeDestino;

    /**
     * Data e hora de saída do voo.
     */
    @Column(name = "data_saida")
    private LocalDateTime dataSaida;

    /**
     * Data e hora de chegada do voo.
     */
    @Column(name = "data_chegada")
    private LocalDateTime dataChegada;

    /**
     * Registro aéreo ao qual este segmento pertence.
     */
    @ManyToOne
    @JoinColumn(name = "aereo_id")
    @JsonIgnore
    private AereoEntity aereo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDateTime getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(LocalDateTime dataChegada) {
        this.dataChegada = dataChegada;
    }
    public AereoEntity getAereo() {
        return aereo;
    }
    public void setAereo(AereoEntity aereo) {
        this.aereo = aereo;
    }


}
