package com.example.post.soap;

import br.com.seuprojeto.soap.client.ObjectFactory;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Factory responsável pela criação do objeto {@link PesquisarSolicitacaoRequest}.
 *
 * centraliza a montagem da requisição SOAP utilizando as classes
 * geradas pelo wsimport e o {@link ObjectFactory}, encapsulando a complexidade do uso da lista {@code content}.
 */
public class PesquisarSolicitacaoRequestFactory {
    /**
     * ObjectFactory gerado pelo wsimport, responsável pela criação
     * dos elementos JAXB utilizados na requisição SOAP
     */
    private static final ObjectFactory factory = new ObjectFactory();

    /**
     * Cria e popula um {@link PesquisarSolicitacaoRequest} com os
     * parâmetros de filtro informados.
     *
     * @param dataInicial data inicial do périodo de pesquisa
     * @param dataFinal data final do periodo de pesquisa
     * @param registroInicial índice inicial de paginação
     * @param quantidade quantidade de registros por página
     * @return objeto {@link PesquisarSolicitacaoRequest} pronto para envio ao serviço SOAP
     */
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
