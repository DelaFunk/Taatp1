package dao;

import javax.persistence.EntityManager;

import enties.Wind;

public class WindDao extends AbstractDao<Wind, Long> implements Dao<Wind, Long>{

	public WindDao(EntityManager manager) {
		super(manager);
	}
	
	public Wind create(Wind entity) {
		return super.create(entity);
	}
	
	public Wind findById(Long id) {
		return manager.find(Wind.class, id);
	}
	
	public Wind update(Wind entity) {
		return super.update(entity);
	}
	
	public void delete(Wind entity) {
		super.delete(entity);
	}
}