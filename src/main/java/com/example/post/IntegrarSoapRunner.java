package com.example.post;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import com.example.post.service.PersistirSolicitacaoService;
import com.example.post.service.SolicitacaoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IntegrarSoapRunner implements CommandLineRunner {

    private final SolicitacaoService solicitacaoService;
    private final PersistirSolicitacaoService persistirService;

    public IntegrarSoapRunner(
            SolicitacaoService solicitacaoService,
            PersistirSolicitacaoService persistirService
    ) {
        this.solicitacaoService = solicitacaoService;
        this.persistirService = persistirService;
    }

    @Override
    public void run(String... args) {
        System.out.println("INICIO INTEGRACAO SOAP");

        PesquisarSolicitacaoResponse response =
                solicitacaoService.pesquisarUltimosTresAnos();

        persistirService.salvar(response);

        System.out.println("FIM INTEGRACAO SOAP");
    }
}


