package dao;

import javax.persistence.EntityManager;

import enties.State;

public class StateDao extends AbstractDao<State, Long> implements Dao<State, Long>{

	public StateDao(EntityManager manager) {
		super(manager);
	}
	
	public State create(State entity) {
		return super.create(entity);
	}
	
	public State findById(Long id) {
		return manager.find(State.class, id);
	}
	
	public State update(State entity) {
		return super.update(entity);
	}
	
	public void delete(State entity) {
		super.delete(entity);
	}
}
