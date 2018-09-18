package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import enties.User;

public abstract class AbstractDao<T, K> implements Dao<T, K>{


	private EntityManager manager;
	
	public AbstractDao(EntityManager manager)	{
		this.manager = manager;
	}

	public T create(T entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(entity);
		}catch(Exception e) {
			tx.rollback();
		}
		tx.commit();
		return entity;
	}

	//public T findById(K id) {
	//	return manager.find(T, id);
	//}

	public T update(T entity) {
		manager.merge(entity);
		return entity;
	}

	public void delete(T entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			manager.remove(entity);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
	}
}
