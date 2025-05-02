package br.com.almoxerifado.dto;

import java.util.List;
import java.util.Random;

import br.com.almoxerifado.entidade.Movimentacao;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarItemDto{

	    private Long id;
	    private Integer codigo = new Random().nextInt(9000) + 1000;	
	    private String nome;
	    private String categoria;
	    private Integer quantidadeMinima;
	    private String unidadeMedida;
	    private Integer saldoAtual;
	    private List<Movimentacao> movimentacoes;
}
