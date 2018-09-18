package dao;

import javax.persistence.EntityManager;

import enties.Wave;

public class WaveDao extends AbstractDao<Wave, Long> implements Dao<Wave, Long>{

	public WaveDao(EntityManager manager) {
		super(manager);
	}
	
	public Wave create(Wave entity) {
		return super.create(entity);
	}
	
	public Wave findById(Long id) {
		return manager.find(Wave.class, id);
	}
	
	public Wave update(Wave entity) {
		return super.update(entity);
	}
	
	public void delete(Wave entity) {
		super.delete(entity);
	}
}