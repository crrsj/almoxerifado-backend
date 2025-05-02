package br.com.almoxerifado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.almoxerifado.entidade.ItemEstoque;

public interface ItemEstoqueRepositorio extends JpaRepository<ItemEstoque, Long>{

}
