package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import enties.User;

public class UserDao implements Dao<User, Long>{
	
	private EntityManager manager;
	
	public UserDao(EntityManager manager){
		this.manager = manager;
	}

	public User create(User entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			manager.persist(entity);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return entity;
	}

	public User findById(Long id) {
		return manager.find(User.class,	id);
	}

	public User update(User entity) {
		manager.merge(entity);
		return entity;
	}

	public void delete(User entity) {
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
