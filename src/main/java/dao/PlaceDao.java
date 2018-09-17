package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import enties.Place;
import enties.User;

public class PlaceDao implements Dao<Place, Long>{
private EntityManager manager;
	
	public PlaceDao(EntityManager manager){
		this.manager = manager;
	}

	public Place create(Place entity) {
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

	public Place findById(Long id) {
		return manager.find(Place.class,	id);
	}

	public Place update(Place entity) {
		manager.merge(entity);
		return entity;
	}

	public void delete(Place entity) {
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
