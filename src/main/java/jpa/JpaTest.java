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
import enties.Activity;


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
        try {
        	test.createActivity();
        }catch (Exception e) {
        	e.printStackTrace();
        }
        tx.commit();

        test.listUsers();
        test.listActivity();
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
            System.out.println("next user: " + next);
        }
    }
    
    private void createWeather() {
    	int numOfWeather = manager.createQuery("Select w From Weather w", Weather.class).getResultList().size();
    	if(numOfWeather == 0){
    		Snow snow = new Snow("low");
    		State state = new State("rain");
    		Wind wind = new Wind("low");
    		Wave wave = new Wave("low");
    		manager.persist(snow);
    		manager.persist(state);
    		manager.persist(wind);
    		manager.persist(wave);
    		manager.persist(new Weather(30,state,snow,wind,wave));
    	}
    }
    
    private void listWeather() {
        List<Weather> resultList = manager.createQuery("Select w From Weather w", Weather.class).getResultList();
        System.out.println("num of weathers:" + resultList.size());
        for (Weather next : resultList) {
            System.out.println("next weather: " + next);
        }
    }
    
    private void createActivity(){
    	int numberOfActivity = manager.createQuery("Select a From Activity a", Activity.class).getResultList().size();
    	if(numberOfActivity == 0){
    		 Place paris = new Place("Paris", 75000);
             manager.persist(paris);
             
            Snow snow = new Snow("low");
     		State state = new State("rain");
     		Wind wind = new Wind("low");
     		Wave wave = new Wave("low");
     		manager.persist(snow);
     		manager.persist(state);
     		manager.persist(wind);
     		manager.persist(wave);
     		Weather temps1 = new Weather(28,state,snow,wind,wave);
     		Weather temps2 = new Weather(10,state,snow,wind,wave);
     		manager.persist(temps1);
     		manager.persist(temps2);
     		List<Weather> weathers = new ArrayList<Weather>();
     		weathers.add(temps1);
     		weathers.add(temps2);
     		
     		List<Place> places = new ArrayList<Place>();
     		places.add(paris);
     		
    		Activity tennis = new Activity ("tennis", places,weathers);
    		manager.persist(tennis);	
    	}
    }
    
    private void listActivity() {
        List<Activity> resultList = manager.createQuery("Select a From Activity a", Activity.class).getResultList();
        System.out.println("num of activity:" + resultList.size());
        for (Activity next : resultList) {
            System.out.println("next Activity: " + next);
        }
    }
    
}
