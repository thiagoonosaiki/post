package com.example.post.proxy;

import br.com.seuprojeto.soap.client.*;
import jakarta.xml.bind.JAXBElement;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

import static com.example.post.logicadeconversao.XmlDataUtil.toXmlDate;


public class IntegrarSoap {
    public static void main(String[] args) {


        System.setProperty(
                "com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty(
                "com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");

        WsSelfBookingService servico = new WsSelfBookingService();
        WsSelfBooking proxy = servico.getWsSelfBookingPort();

        ObjectFactory factory = new ObjectFactory();
        PesquisarSolicitacaoRequest request = factory.createPesquisarSolicitacaoRequest();

// datas
        XMLGregorianCalendar dataInicial = toXmlDate(LocalDateTime.now().minusMonths(36));
        XMLGregorianCalendar dataFinal   = toXmlDate(LocalDateTime.now());

// ORDEM É CRÍTICA
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestDataInicial(dataInicial)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestDataFinal(dataFinal)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestRegistroInicial(1)
        );
        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestQuantidadeRegistros(50)
        );

        PesquisarSolicitacaoResponse response =
                proxy.pesquisarSolicitacao(
                        "base_teste_qa",
                        "d0804903bf4eeefddf55c63fc600ed5c",
                        "5c11ca0bf738c2dbb460479530b26db0",
                        request
                );

        System.out.println("Resultado: " + response.getResultadoAcao());
        System.out.println("Quantidade: " + response.getNumeroSolicitacoes());

        System.out.println("----------");

        if (response != null && response.getSolicitacao() != null) {
            for (Solicitacao solicitacao : response.getSolicitacao()) {
                System.out.println("ID: " + solicitacao.getIdSolicitacao());
                System.out.println("Status: " + solicitacao.getStatusSolicitacao().name());
                System.out.println("Solicitante: " + solicitacao.getSolicitante().getNome());

                if (solicitacao.getPassageiros() != null &&
                solicitacao.getPassageiros().getPassageiro() != null) {
                    for (Passageiro passageiro : solicitacao.getPassageiros().getPassageiro()) {
                        System.out.println("Passageiro: " + passageiro.getNomeCompleto());

                        if (solicitacao.getAereos() != null &&
                        solicitacao.getAereos().getAereo() != null) {
                            for (Aereo aereo : solicitacao.getAereos().getAereo()) {
                                System.out.println("Cia: " + aereo.getCiaValidadora());
                                System.out.println("Loc: " + aereo.getLocalizador());

                                if (solicitacao.getAereos().getAereo() != null &&
                                aereo.getAereoSeguimento() != null) {
                                    for (AereoSeguimento aereoSeguimento : aereo.getAereoSeguimento()) {
                                        System.out.println("Cidade Origem: " + aereoSeguimento.getCidadeOrigem());
                                        System.out.println("Data Saida: " + aereoSeguimento.getDataSaida());
                                        System.out.println("Cidade Destino: " + aereoSeguimento.getCidadeDestino());
                                        System.out.println("Data Chegada: " + aereoSeguimento.getDataChegada());

                                        System.out.println("--------------");

                                    }
                                }
                            }
                        }
                    }
                }

            }



            }


        }







}
