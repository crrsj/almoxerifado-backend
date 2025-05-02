package br.com.almoxerifado.entidade;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.almoxerifado.enums.TipoMovimentacao;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_movimentacoes")
@Data
@NoArgsConstructor
public class Movimentacao {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;	    
	    @Enumerated(EnumType.STRING)
	    private TipoMovimentacao tipo;	    
	    private Integer quantidade;
	    private LocalDate data;
	    private String responsavel;
	    @ManyToOne
	    private ItemEstoque item;
	}

