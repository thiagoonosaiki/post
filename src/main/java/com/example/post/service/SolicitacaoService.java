package com.example.post.service;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoRequest;
import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import com.example.post.soap.PesquisarSolicitacaoRequestFactory;
import com.example.post.soap.WsSelfBookingSoapClient;
import com.example.post.util.XmlDateUtil;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;

@Service
public class SolicitacaoService {
    private final WsSelfBookingSoapClient soapClient;

    public SolicitacaoService() {
        this.soapClient = new WsSelfBookingSoapClient();
    }

    public PesquisarSolicitacaoResponse pesquisarUltimosTresAnos() {

        XMLGregorianCalendar dataInicial =
                XmlDateUtil.toXmlDate(LocalDateTime.now().minusMonths(36));

        XMLGregorianCalendar dataFinal =
                XmlDateUtil.toXmlDate(LocalDateTime.now());

        PesquisarSolicitacaoRequest request =
                PesquisarSolicitacaoRequestFactory.criar(
                        dataInicial,
                        dataFinal,
                        1,
                        50
                );

        return soapClient.pesquisarSolicitacao(
                "base_teste_qa",
                "d0804903bf4eeefddf55c63fc600ed5c",
                "5c11ca0bf738c2dbb460479530b26db0",
                request
        );
    }
}
