package com.example.post.service;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import br.com.seuprojeto.soap.client.Solicitacao;
import com.example.post.domain.entity.SolicitacaoEntity;
import com.example.post.domain.mapper.SolicitacaoEntityMapper;
import com.example.post.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por persistir as solicitações obtidas
 * através da integração SOAP.
 *
 * Converter os objetos do modelo externo (SOAP/JAXB)
 * em entidades de dominio JPA e realiza a persistência
 * no banco de dados.
 */
@Service
public class PersistirSolicitacaoService {

    private final SolicitacaoRepository repository;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param repository repositório responsável pela persistência da entidade {@link SolicitacaoEntity}
     */
    public PersistirSolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

    /**
     * Persiste no banco de dados as solicitações retornadas
     * pelo serviço SOAP.
     *
     * O método ignora respostas nulas ou vazias e garente
     * que toda a operação ocorra dentro de uma transação.
     *
     * @param response resposta retornada pelo serviço SOAP
     */
    @Transactional
    public void salvar(PesquisarSolicitacaoResponse response) {

        if (response == null || response.getSolicitacao() == null) return;

        for (Solicitacao solicitacao : response.getSolicitacao()) {

            SolicitacaoEntity entity =
                    SolicitacaoEntityMapper.toEntity(solicitacao);

            repository.save(entity);
        }
    }
}

