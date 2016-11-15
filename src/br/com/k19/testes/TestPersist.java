package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TestPersist {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_pu");

		EntityManager manager = factory.createEntityManager();

		// Abrindo a transacao
		manager.getTransaction().begin();

		// Objeto no estado new
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Rafael Consentino");

		// Objeto no estado managed
		manager.persist(pessoa);

		// Sincronizando e confirmando a transacao
		manager.getTransaction().commit();

		System.out.println("Pessoa id: " + pessoa.getId());

		manager.close();
		factory.close();
	}

}
