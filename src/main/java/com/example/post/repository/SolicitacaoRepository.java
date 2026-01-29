package com.example.post.repository;

import com.example.post.entity.SolicitacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoEntity, Long> {
}
