package com.example.post.soap;

import br.com.seuprojeto.soap.client.*;


public class SolicitacaoResponsePrinter {

    public static void imprimir(PesquisarSolicitacaoResponse response) {

        if (response == null || response.getSolicitacao() == null) return;

        for (Solicitacao solicitacao : response.getSolicitacao()) {

            System.out.println("ID: " + solicitacao.getIdSolicitacao());
            System.out.println("Status: " + solicitacao.getStatusSolicitacao());
            System.out.println("Solicitante: " + solicitacao.getSolicitante().getNome());

            if (solicitacao.getPassageiros() == null) continue;

            for (Passageiro passageiro : solicitacao.getPassageiros().getPassageiro()) {
                System.out.println("Passageiro: " + passageiro.getNomeCompleto());
            }

            if (solicitacao.getAereos() == null) continue;

            for (Aereo aereo : solicitacao.getAereos().getAereo()) {
                System.out.println("Cia: " + aereo.getCiaValidadora());
                System.out.println("Loc: " + aereo.getLocalizador());

                if (aereo.getAereoSeguimento() == null) continue;

                for (AereoSeguimento seg : aereo.getAereoSeguimento()) {
                    System.out.println("Origem: " + seg.getCidadeOrigem());
                    System.out.println("Destino: " + seg.getCidadeDestino());
                }
            }

            System.out.println("------------");
        }
    }
}
