package br.com.almoxerifado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almoxerifado.entidade.Movimentacao;

public interface MovimentacaoRepositorio extends JpaRepository<Movimentacao, Long>{

}
