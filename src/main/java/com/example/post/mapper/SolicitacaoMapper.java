package com.example.post.mapper;

import br.com.seuprojeto.soap.client.Solicitacao;
import com.example.post.entity.SolicitacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoMapper {

    public SolicitacaoEntity toEntity(Solicitacao soap) {
        SolicitacaoEntity entity = new SolicitacaoEntity();

        entity.setIdSolicitacao(
                soap.getIdSolicitacaoPrincipal().longValue()
        );

        entity.setStatus(soap.getStatusSolicitacao().name());

        entity.setSolicitante(soap.getSolicitante().getNomeCompleto());




    return entity;
    }
}
