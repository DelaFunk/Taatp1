package dao;

import javax.persistence.EntityManager;

import enties.Place;

public class PlaceDao extends AbstractDao<Place, Long> implements Dao<Place, Long>{
	
	public PlaceDao(EntityManager manager) {
		super(manager);
	}
	
	public Place create(Place entity) {
		return super.create(entity);
	}
	
	public Place findById(Long id) {
		return manager.find(Place.class, id);
	}
	
	public Place update(Place entity) {
		return super.update(entity);
	}
	
	public void delete(Place entity) {
		super.delete(entity);
	}
}
	
