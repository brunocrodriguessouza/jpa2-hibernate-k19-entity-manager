package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteFind {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_pu");

		EntityManager manager = factory.createEntityManager();

		// Objeto no estado managed
		Pessoa pessoa = manager.find(Pessoa.class, 1L);
		System.out.println("Id: " + pessoa.getId());
		System.out.println("Nome: " + pessoa.getNome());

		manager.close();
		factory.close();

	}

}
