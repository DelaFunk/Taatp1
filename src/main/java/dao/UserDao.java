package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

import enties.User;

public class UserDao {
	
	private EntityManager manager;
	
	public UserDao(EntityManager manager){
		manager = manager;
	}

	public User createUser(User user){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try{
			manager.persist(user);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return user;
	}
	
	public User findUserById(Long idUser){
		return manager.find(User.class,	idUser);
	}
	
	public User changePseudo(Long idUser, String pseudo){
		User user = this.findUserById(idUser);
		user.setPseudo(pseudo);
		EntityTransaction tx = manager.getTransaction();
		try{

		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return user;
	}
	
	public User changePassword(Long idUser, String password){
		User user = this.findUserById(idUser);
		user.setPassword(password);
		EntityTransaction tx = manager.getTransaction();
		try{
			
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
		return user;
	}
	
	public User changeMail(Long idUser, String mail){
		User user = this.findUserById(idUser);
		user.setMail(mail);
		return user;
	}
	
	public void deleteUser(Long idUser){
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		User user = this.findUserById(idUser);
		try{
			manager.remove(user);
		}catch(Exception e){
			tx.rollback();
		}
		tx.commit();
	}
}
