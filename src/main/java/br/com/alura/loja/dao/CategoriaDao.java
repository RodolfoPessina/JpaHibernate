package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Categoria;

public class CategoriaDao {
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void CadastrarProduto(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void AtualizarProduto(Categoria categoria) {
		this.em.merge(categoria);
	}
	
	public void remover(Categoria categoria) {
	    categoria = em.merge(categoria);
	        this.em.remove(categoria);
	    }


}
