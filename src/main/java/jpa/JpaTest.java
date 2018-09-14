package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import enties.User;
import enties.Place;
import enties.Weather;
import enties.Snow;
import enties.State;
import enties.Wave;
import enties.Wind;


public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
        	test.createWeather();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        tx.commit();

        test.listUsers();
        test.listWeather();
            
        manager.close();
        System.out.println(".. done");
    }

    private void createUsers() {
        int numOfUsers = manager.createQuery("Select u From User u", User.class).getResultList().size();
        if (numOfUsers == 0) {
            Place place = new Place("Rennes", 35000);
            manager.persist(place);

            manager.persist(new User("Paul", "abdce", "paul@mail.com"));
            manager.persist(new User("Pierre", "12345", "pierre@mail.com"));

        }
    }

    private void listUsers() {
        List<User> resultList = manager.createQuery("Select u From User u", User.class).getResultList();
        System.out.println("num of users:" + resultList.size());
        for (User next : resultList) {
            System.out.println("next users: " + next);
        }
    }
    
    private void createWeather() {
    	int numOfWeather = manager.createQuery("Select u From Weather u", Weather.class).getResultList().size();
    	if(numOfWeather == 0){
    		Snow snow = new Snow("peu");
    		State state = new State("pluie");
    		Wind wind = new Wind("peu");
    		Wave wave = new Wave("faible");
    		manager.persist(snow);
    		manager.persist(state);
    		manager.persist(wind);
    		manager.persist(wave);
    		manager.persist(new Weather(30,state,snow,wind,wave));
    	}
    }
    
    private void listWeather() {
        List<Weather> resultList = manager.createQuery("Select u From Weather u", Weather.class).getResultList();
        System.out.println("num of users:" + resultList.size());
        for (Weather next : resultList) {
            System.out.println("next users: " + next);
        }
    }
}
