package com.br.biblioteca.JPA_PostgreSQL;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.list;

public class app {
	public static void main (String[] args) throws IOException{
		
		EntityManager em = JPAUtil.getEntityManager();
		
		LivroDAO livroDAO = new LiroDAO(em);
		EditoraDAO editoraDAO = new EditoraDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		AutorDAO autorDAO = new AutorDAO(em);
		
		Categoria categoria1 = new categoria("Ação");
		Categoria categoria2 = new categoria("Comédia");
		
		Editora editora1 = new Editora("Aleph");
		Editora editora2 = new Editora("Rocco");
		
		Autor autor1 = new Autor("Lucas lschlestein");
		Autor autor2 = new Autor("André Santos");
		
		List<Autor> autores = new ArrayList<>();
		autores.add(autor1);
		autores.add(autor2);
		
		Livro harryPotter = new livro("Harry Potter", 1999, 123456789, categoria1, editora1, autores);
		Livro piorQueTaNaoFica = new livro("Pior que tá não fica", 1999, 123456789, categoria2, editora2, autores);
		Livro oEspadachimDeCarvao = new livro("O Espadachim de Carvão", 1999, 123456789, categoria1, editora2, autores);
		
		em.getTransaction().begin();
	}
}