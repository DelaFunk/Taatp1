package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import enties.User;

public class UserDao extends AbstractDao<User, Long> implements Dao< User, Long>{
	
	public UserDao(EntityManager manager) {
		super(manager);
	}

	private EntityManager manager;


	public User create(User entity) {
		return super.create(entity);
	}

	public User findById(Long id) {
		return manager.find(User.class,	id);
	}

	public User update(User entity) {
		return super.update(entity);
	}

	public void delete(User entity) {
		super.delete(entity);
	}
}
