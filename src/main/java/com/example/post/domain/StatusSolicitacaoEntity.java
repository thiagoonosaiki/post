package com.example.post.domain;

/**
 * Enumeração que representa os possíveis status
 * de uma solciitação do dóminio da aplicação.
 */
public enum StatusSolicitacaoEntity {
        /** Solicitação concluída com sucesso */
        CONCLUIDA,
        /** SOlicitação cancelada */
        CANCELADA,
        /** Solciitação pendente de aprovação */
        PENDENTE_APROVACAO
}
