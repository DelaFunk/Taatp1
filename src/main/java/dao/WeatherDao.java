package dao;

import javax.persistence.EntityManager;

import enties.Weather;

public class WeatherDao extends AbstractDao<Weather, Long> implements Dao<Weather, Long>{

	public WeatherDao(EntityManager manager) {
		super(manager);
	}
	
	public Weather create(Weather entity) {
		return super.create(entity);
	}
	
	public Weather findById(Long id) {
		return manager.find(Weather.class, id);
	}
	
	public Weather update(Weather entity) {
		return super.update(entity);
	}
	
	public void delete(Weather entity) {
		super.delete(entity);
	}
}
