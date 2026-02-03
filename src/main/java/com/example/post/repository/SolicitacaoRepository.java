package com.example.post.repository;

import com.example.post.domain.entity.SolicitacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório JPA responsável pelas operações de persistência
 * da entidade {@link SolicitacaoEntity}.
 *
 * Fornece métodos CRUD e suporte a consultas
 * através do Spring Data JPA
 */
public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity, Long> {
}
