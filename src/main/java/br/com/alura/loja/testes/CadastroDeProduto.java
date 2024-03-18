package br.com.alura.loja.testes;



import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1);
		
		System.out.println(p.getPreco());
		
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p1 -> System.out.println(p1.getNome()));
		
		Double precoDoProduto = produtoDao.buscarPorNomeDoProduto("iphone");
		System.out.println(precoDoProduto);
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("iphone", "bonito", 1500.00, celulares);
		
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.CadastrarProduto(celulares);
		produtoDao.CadastrarProduto(celular);
		em.getTransaction().commit();
		em.close();
	}

}
