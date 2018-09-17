package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import enties.Snow;


public class SnowDao {

private EntityManager manager;

	public SnowDao(EntityManager manager){
		this.manager = manager;
	}
	
	public Snow createSnow(Snow snow) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.persist(snow);
		}catch(Exception e) {
			tx.rollback();
		}
		tx.commit();
		return snow;
	}

	public Snow findSnowById(long idSnow) {
		return manager.find(Snow.class, idSnow);
	}
	
	public Snow changeLabel(long idSnow, String label) {
		Snow snow = this.findSnowById(idSnow);
		snow.setLabel(label);
		EntityTransaction tx = manager.getTransaction();
		tx.commit();
		return snow;
	}
	
	public void deleteSnow(Snow snow) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			manager.remove(snow);
		}catch(Exception e) {
			tx.rollback();
		}
		tx.commit();
	}
}
