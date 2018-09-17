package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import enties.Activity;


public class ActivityDao implements Dao<Activity, Long>{
	private EntityManager manager;
	
	public ActivityDao (EntityManager manager){
		this.manager = manager;
	}
	public Activity create (Activity entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(entity);
		}catch (Exception e) {
			tx.rollback();
		}
		tx.commit();
		return entity;
	}
	
	public Activity findById(Long id) {
		return manager.find(Activity.class, id);
	}
	
	public Activity update (Activity entity) {
		manager.merge(entity);
		return entity;
	}
	
	public void delete (Activity entity) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.remove(entity);
		}catch(Exception e) {
			tx.rollback();
		}
		tx.commit();
	}
	

}
