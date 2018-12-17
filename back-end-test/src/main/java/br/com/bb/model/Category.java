package br.com.bb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category", targetEntity = Product.class)
	private List<Product> produtcs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProdutcs() {
		return produtcs;
	}

	public void setProdutcs(List<Product> produtcs) {
		this.produtcs = produtcs;
	}

}
