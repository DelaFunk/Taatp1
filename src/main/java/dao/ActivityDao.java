package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import enties.Activity;
import enties.User;


public class ActivityDao  extends AbstractDao<Activity, Long> implements Dao< Activity, Long>{
	
	public ActivityDao(EntityManager manager) {
		super(manager);
	}

	private EntityManager manager;


	public Activity create(Activity entity) {
		return super.create(entity);
	}

	public Activity findById(Long id) {
		return manager.find(Activity.class,	id);
	}

	public Activity update(Activity entity) {
		return super.update(entity);
	}

	public void delete(Activity entity) {
		super.delete(entity);
	}
	

}
