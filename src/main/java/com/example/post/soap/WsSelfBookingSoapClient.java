package com.example.post.soap;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import br.com.seuprojeto.soap.client.WsSelfBooking;
import br.com.seuprojeto.soap.client.WsSelfBookingService;
import jakarta.xml.ws.BindingProvider;

/**
 * Cliente responsável pela comunicação com o serviço SOAP
 * WsSelfbooking (Lemontech)
 *
 * Encapsula o uso das classes geradas pelo wsimport,
 * isolando a integração SOAP do restante da aplicação.
 */
public class WsSelfBookingSoapClient {
    private final WsSelfBooking proxy;

    /**
     * Cria o cliente SOAP e inicializa o proxy de comunicação
     * com o serviço Wsselfbooking.
     */
    public WsSelfBookingSoapClient() {
        WsSelfBookingService service = new WsSelfBookingService();
        this.proxy = service.getWsSelfBookingPort();

        configurarTimeout(proxy);
    }

    private void configurarTimeout(WsSelfBooking port) {
        BindingProvider bp = (BindingProvider) port;

        bp.getRequestContext().put(
                "com.sun.xml.ws.connect.timeout", 10_000
        );
        bp.getRequestContext().put(
                "com.sun.xml.ws.request.timeout", 30_000
        );
    }

    /**
     * Executa a operação de pesquisa de solicitacao no serviço SOAP
     *
     * @param keyClient chave de autentica~çao do cliente
     * @param username usuário de acesso ao serviço
     * @param password senha de acesso ao serviço
     * @param request objeto de requisição da pesquisa
     * @return resposta do serviço SOAP com as solciitações encontradas
     */
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
