package br.com.almoxerifado.servico;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.almoxerifado.dto.AtualizarItemDto;
import br.com.almoxerifado.dto.BuscarItemEstoque;
import br.com.almoxerifado.dto.CriarItemDto;
import br.com.almoxerifado.entidade.ItemEstoque;
import br.com.almoxerifado.repositorio.ItemEstoqueRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class AlmoxerifadoServico {
	
	private final ModelMapper modelMapper;
	private final ItemEstoqueRepositorio itemEstoqueRepositorio;
	
	public ItemEstoque criarItem(CriarItemDto criarItemDto) {
		return itemEstoqueRepositorio.save(modelMapper.map(criarItemDto, ItemEstoque.class));
	}
	
	public Page<BuscarItemEstoque>buscarItens(Pageable pageable){
		return itemEstoqueRepositorio.findAll(pageable)
				.map(listar -> modelMapper.map(listar, BuscarItemEstoque.class));
	}
	
	public ItemEstoque buscarPorId(Long id) {
		Optional<ItemEstoque>buscar = itemEstoqueRepositorio.findById(id);
		return buscar.orElseThrow();
	}
	
	public void excluirItem(Long id) {
		buscarPorId(id);
		itemEstoqueRepositorio.deleteById(id);
	}

	public ItemEstoque atualizarItem(AtualizarItemDto itemDto,Long id) {
	itemDto.setItemId(id);
	return itemEstoqueRepositorio.save(modelMapper.map(itemDto, ItemEstoque.class));
		
	}
}
