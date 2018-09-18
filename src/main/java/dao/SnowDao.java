package dao;

import javax.persistence.EntityManager;

import enties.Snow;



public class SnowDao extends AbstractDao<Snow, Long> implements Dao<Snow, Long> {
		
	public SnowDao(EntityManager manager) {
		super(manager);
	}
	
	public Snow create(Snow entity) {
		return super.create(entity);
	}
	
	public Snow findById(Long id) {
		return manager.find(Snow.class,	id);
	}
	
	public Snow update(Snow entity) {
		return super.update(entity);
	}
	
	public void delete(Snow entity) {
		super.delete(entity);
	}
}
