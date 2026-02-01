package com.example.post.service;

import br.com.seuprojeto.soap.client.PesquisarSolicitacaoResponse;
import br.com.seuprojeto.soap.client.Solicitacao;
import com.example.post.domain.entity.SolicitacaoEntity;
import com.example.post.domain.mapper.SolicitacaoEntityMapper;
import com.example.post.repository.SolicitacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PersistirSolicitacaoService {

    private final SolicitacaoRepository repository;

    public PersistirSolicitacaoService(SolicitacaoRepository repository) {
        this.repository = repository;
    }

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

