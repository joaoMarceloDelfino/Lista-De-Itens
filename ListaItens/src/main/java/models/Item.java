package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Table(name="itens")
@Entity()
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descricao;
	private Double quantidade;
	public Item() {
		
	}
	public Item(String nome, String descricao, Double quantidade) {
		this.nome=nome;
		this.descricao=descricao;
		this.quantidade=quantidade;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return nome;
	}	 

}
