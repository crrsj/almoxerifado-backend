package br.com.almoxerifado.entidade;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.almoxerifado.enums.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_itemEstoques")
@Data
@NoArgsConstructor
public class ItemEstoque {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	    
	    private Integer codigo = new Random().nextInt(9000) + 1000;	
	    private String nome;
	    private Categoria categoria;
	    private Integer quantidadeMinima;
	    private String unidadeMedida;
	    private Integer saldoAtual;
        @JsonIgnore      
	    @OneToMany(mappedBy = "item")
	    private List<Movimentacao> movimentacoes;
}
