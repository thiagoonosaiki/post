package com.example.post.domain.mapper;

import br.com.seuprojeto.soap.client.*;
import com.example.post.domain.entity.AereoEntity;
import com.example.post.domain.entity.AereoSeguimentoEntity;
import com.example.post.domain.entity.PassageiroEntity;
import com.example.post.domain.entity.SolicitacaoEntity;

public class SolicitacaoEntityMapper {

    public static SolicitacaoEntity toEntity(Solicitacao solicitacaoSoap) {

        SolicitacaoEntity entity = new SolicitacaoEntity();
        entity.setIdSolicitacao(solicitacaoSoap.getIdSolicitacao());
        entity.setStatus(StatusSolicitacao.valueOf(solicitacaoSoap.getStatusSolicitacao().name()));
        entity.setSolicitante(
                solicitacaoSoap.getSolicitante().getNome()
        );

        // Passageiros
        if (solicitacaoSoap.getPassageiros() != null) {
            for (Passageiro p : solicitacaoSoap.getPassageiros().getPassageiro()) {
                PassageiroEntity pe = new PassageiroEntity();
                pe.setNome(p.getNomeCompleto());
                pe.setSolicitacao(entity);

                entity.getPassageiros().add(pe);
            }
        }

        // Aéreos
        if (solicitacaoSoap.getAereos() != null) {
            for (Aereo a : solicitacaoSoap.getAereos().getAereo()) {

                AereoEntity ae = new AereoEntity();
                ae.setCia(a.getCiaValidadora());
                ae.setLocalizador(a.getLocalizador());
                ae.setSolicitacao(entity);

                if (a.getAereoSeguimento() != null) {
                    for (AereoSeguimento seg : a.getAereoSeguimento()) {

                        AereoSeguimentoEntity se = new AereoSeguimentoEntity();
                        se.setCidadeOrigem(seg.getCidadeOrigem());
                        se.setCidadeDestino(seg.getCidadeDestino());
                        se.setDataSaida(
                                seg.getDataSaida().toGregorianCalendar().toZonedDateTime().toLocalDateTime()
                        );
                        se.setDataChegada(
                                seg.getDataChegada().toGregorianCalendar().toZonedDateTime().toLocalDateTime()
                        );

                        se.setAereo(ae);
                        ae.getSeguimentos().add(se);
                    }
                }

                entity.getAereos().add(ae);
            }
        }

        return entity;
    }
}
