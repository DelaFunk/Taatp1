package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import enties.Place;
import enties.User;

public class PlaceDao {
private EntityManager manager;
	
	public PlaceDao(EntityManager manager){
		this.manager = manager;
	}

	public Place createPlace(Place place){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			manager.persist(place);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return place;
	}
	
	public Place findPlaceById(Long idPlace){
		return manager.find(Place.class,idPlace);
	}
	
	public Place changeName(Long idPlace, String name){
		Place place = this.findPlaceById(idPlace);
		place.setName(name);
		EntityTransaction tx = manager.getTransaction();
		try{

		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return place;
	}
	
	public Place changePostCode(Long idPlace, Integer postCode){
		Place place = this.findPlaceById(idPlace);
		place.setPostCode(postCode);
		EntityTransaction tx = manager.getTransaction();
		try {
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return place;
	}
	
	public void deletePlace(Place place){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			manager.remove(place);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
	}
}
