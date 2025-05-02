package br.com.almoxerifado.controle;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.almoxerifado.dto.AtualizarItemDto;
import br.com.almoxerifado.dto.BuscarItemEstoque;
import br.com.almoxerifado.dto.CriarItemDto;
import br.com.almoxerifado.servico.AlmoxerifadoServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/itens")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlmoxerifadoControle {

	private final ModelMapper modelMapper;
	private final AlmoxerifadoServico almoxerifadoServico;
	
	
	@PostMapping
	public ResponseEntity<CriarItemDto>criarItem(@RequestBody CriarItemDto criarItemDto){
		var criar = almoxerifadoServico.criarItem(criarItemDto);
		return new ResponseEntity<>(modelMapper.map(criar, CriarItemDto.class),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<BuscarItemEstoque>>buscarItens(@RequestParam(defaultValue = "0")int pagina,
			                                            @RequestParam(defaultValue = "10")int tamanho){
		var paginando = PageRequest.of(pagina, tamanho);
		List<BuscarItemEstoque>buscar = almoxerifadoServico.buscarItens(paginando).getContent();
		return new ResponseEntity<>(buscar,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BuscarItemEstoque>buscarPórId(@PathVariable Long id){
		var buscar = almoxerifadoServico.buscarPorId(id);
		return new ResponseEntity<>(modelMapper.map(buscar, BuscarItemEstoque.class),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluirItens(@PathVariable Long id) {
		 almoxerifadoServico.excluirItem(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/atualize/{id}")
	public ResponseEntity<AtualizarItemDto>atualizarItem(@RequestBody AtualizarItemDto atualizarItemDto,@PathVariable Long id){
		var atualizar = almoxerifadoServico.atualizarItem(atualizarItemDto, id);
		return new ResponseEntity<>(modelMapper.map(atualizar, AtualizarItemDto.class),HttpStatus.OK);
		
	}
}

   
