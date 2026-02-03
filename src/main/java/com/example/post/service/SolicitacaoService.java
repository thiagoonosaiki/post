package com.example.post.service;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import com.example.post.soap.PesquisarSolicitacaoRequestFactory;
import com.example.post.soap.WsSelfBookingSoapClient;
import com.example.post.util.XmlDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

/**
 *Serviço responsável por consultar solicitações de viagem
 *no serviço SOAP WsSelfBooking (Lemontech).
 *
 *Este serviço aplica regras de negócio relacionadas
 *ao período de consulta e orquestra a chamada ao cliente SOAP.
 */
@Service
public class SolicitacaoService {

    private static final Logger log =
            LoggerFactory.getLogger(SolicitacaoService.class);

    private final WsSelfBookingSoapClient soapClient;

    public SolicitacaoService() {
        this.soapClient = new WsSelfBookingSoapClient();
    }

    /**
     * Consulta solicitações de viagem referentes aos últimos três anos.
     * <p>
     * A regra de negócio considera um período de 36 meses
     * contado a partir da data atual
     *
     * @return resposta do serviço Soap contendo as solciitacões encontradas
     */
    public PesquisarSolicitacaoResponse pesquisarUltimosTresAnos() {

        log.info("ANTES da chamada SOAP");

        PesquisarSolicitacaoResponse response;

        try {
            // Define o período de busca: últimos 36 meses
            XMLGregorianCalendar dataInicial =
                    XmlDateUtil.toXmlDate(LocalDateTime.now().minusMonths(36));

            XMLGregorianCalendar dataFinal =
                    XmlDateUtil.toXmlDate(LocalDateTime.now());

            // Cria o request com paginação padrão (página 1, 50 registros)
            PesquisarSolicitacaoRequest request =
                    PesquisarSolicitacaoRequestFactory.criar(
                            dataInicial,
                            dataFinal,
                            1,
                            50
                    );


            response = soapClient.pesquisarSolicitacao(
                    "base_teste_qa",
                    "d0804903bf4eeefddf55c63fc600ed5c",
                    "5c11ca0bf738c2dbb460479530b26db0",
                    request
            );

            log.info("DEPOIS da chamada SOAP");

            return response;
        } catch (Exception e) {
            log.error("Erro na chamada SOAP", e);
            throw e;
        }
    }
}

