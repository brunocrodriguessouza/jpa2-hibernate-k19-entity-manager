package br.com.k19.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Pessoa;

public class TesteMerge {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("K21_entity_manager_pu");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		// Objeto no estado managed
		Pessoa pessoa = manager.find(Pessoa.class, 1L);

		// Objeto no estado detached
		manager.detach(pessoa);

		// Objeto pessoa2 no estado managed
		Pessoa pessoa2 = manager.merge(pessoa);

		// Alterando o conteudo o objeto
		pessoa2.setNome("Jonas Hirata");

		// Sincronizando e confirmando a transacao
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

}
