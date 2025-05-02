package br.com.almoxerifado.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_fornecedores")
@Data
@NoArgsConstructor
public class Forneedor {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nome;
    private String cnpj;
    private String telefone;
}
