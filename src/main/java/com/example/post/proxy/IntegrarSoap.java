package com.example.post.proxy;

import br.com.seuprojeto.soap.client.ObjectFactory;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;
import br.com.seuprojeto.soap.client.WsSelfBooking;
import br.com.seuprojeto.soap.client.WsSelfBookingService;
import jakarta.xml.bind.JAXBElement;

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

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime tresMesesAtras = agora.minusMonths(3);

        XMLGregorianCalendar dataInicial = toXmlDate(tresMesesAtras);
        XMLGregorianCalendar dataFinal = toXmlDate(agora);

        PesquisarSolicitacaoRequest request = factory.createPesquisarSolicitacaoRequest();

//        JAXBElement<Integer> registroInicial =
//                factory.createPesquisarSolicitacaoRequestRegistroInicial(1);


        request.getContent().clear();

//        request.getContent().add(registroInicial);

        request.getContent().add(
                factory.createPesquisarSolicitacaoRequestRegistroInicial(1)
        );

        request.getContent().add(factory.createPesquisarSolicitacaoRequestQuantidadeRegistros(50));

        request.getContent().add(factory.createPesquisarSolicitacaoRequestDataAlteracaoInicial(dataInicial));
        request.getContent().add(factory.createPesquisarSolicitacaoRequestDataAlteracaoFinal(dataFinal));







        proxy.pesquisarSolicitacao("base_teste_qa", "d0804903bf4eeefddf55c63fc600ed5c", "5c11ca0bf738c2dbb460479530b26db0", request);
    }
}
