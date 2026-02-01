package com.example.post.soap;

import br.com.seuprojeto.soap.client.ObjectFactory;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;

import javax.xml.datatype.XMLGregorianCalendar;

public class PesquisarSolicitacaoRequestFactory {
    private static final ObjectFactory factory = new ObjectFactory();

    public static PesquisarSolicitacaoRequest criar(
            XMLGregorianCalendar dataInicial,
            XMLGregorianCalendar dataFinal,
            int registroInicial,
            int quantidade
    ) {
        PesquisarSolicitacaoRequest request = factory.createPesquisarSolicitacaoRequest();

        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestDataInicial(dataInicial)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestDataFinal(dataFinal)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestRegistroInicial(registroInicial)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestQuantidadeRegistros(quantidade)
        );

        return request;
    }
}
