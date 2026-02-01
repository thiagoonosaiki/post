package com.example.post.soap;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import br.com.seuprojeto.soap.client.WsSelfBooking;
import br.com.seuprojeto.soap.client.WsSelfBookingService;

public class WsSelfBookingSoapClient {
    private final WsSelfBooking proxy;

    public WsSelfBookingSoapClient() {
        WsSelfBookingService service = new WsSelfBookingService();
        this.proxy = service.getWsSelfBookingPort();
    }

    public PesquisarSolicitacaoResponse pesquisarSolicitacao(
            String keyClient,
            String username,
            String password,
            PesquisarSolicitacaoRequest request
    ) {
        return proxy.pesquisarSolicitacao(
                keyClient,
                username,
                password,
                request
        );
    }
}
