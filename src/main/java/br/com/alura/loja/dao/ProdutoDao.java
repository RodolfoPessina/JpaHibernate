package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	
	
	public void CadastrarProduto(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(int id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
		
	}
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter(nome, "nome")
				.getResultList();
		
	}
	
	public List<Produto> buscarPorNomeCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter(nome, "nome")
				.getResultList();
		
	}
	
	public Double buscarPorNomeDoProduto(String nome) {
	    String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
	        return em.createQuery(jpql,Double.class)
	                    .setParameter("nome", nome)
	                    .getSingleResult();
	    }

}
