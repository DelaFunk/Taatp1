package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dao.ActivityDao;
import dao.PlaceDao;
import dao.SnowDao;
import dao.StateDao;
import dao.UserDao;
import dao.WaveDao;
import dao.WeatherDao;
import dao.WindDao;
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
       
        test.createUsers();
        test.createWeather();
        
        EntityTransaction tx = manager.getTransaction();      
        tx.begin();
        try {
        	test.createActivity();
        }catch (Exception e) {
        	e.printStackTrace();
        }
        tx.commit();

        test.listUsers();
        test.listActivity();
        test.listWeather();
        test.listActivity();
            
        manager.close();
        System.out.println(".. done");
    }

    private void createUsers() {
        int numOfUsers = manager.createQuery("Select u From User u", User.class).getResultList().size();
        if (numOfUsers == 0) {
            Place place = new Place("Rennes", 35000);
            PlaceDao placeDao = new PlaceDao(manager);
            placeDao.create(place);

            UserDao userDao = new UserDao(manager);
            User user1 = new User("Paul", "abdce", "paul@mail.com");
            User user2 = new User("Pierre", "12345", "pierre@mail.com");
            userDao.create(user1);
            userDao.create(user2);
            
            user1.setPassword("ecdba");
            userDao.update(user1);
            System.out.println("user find :" + userDao.findById(user2.getIdUser()).toString());
            userDao.delete(user1);
            userDao.delete(user2);

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
    		SnowDao snowDao = new SnowDao(manager);
    		State state = new State("rain");
    		StateDao stateDao = new StateDao(manager);
    		Wind wind = new Wind("low");
    		WindDao windDao = new WindDao(manager);
    		Wave wave = new Wave("low");
    		WaveDao waveDao = new WaveDao(manager);
    		snowDao.create(snow);
    		stateDao.create(state);
    		windDao.create(wind);
    		waveDao.create(wave);
    		Weather weather = new Weather(30,state,snow,wind,wave);
    		WeatherDao weatherDao = new WeatherDao(manager);
    		weatherDao.create(weather);
    		snow.setLabel("medium");
    		state.setLabel("sun");
    		wind.setLabel("medium");
    		wave.setLabel("medium");
    		//Snow snowTest = new Snow("high");
    		//SnowDao snowDaotest = new SnowDao(manager);
    		//snowDaotest.create(snowTest);
    		weather.setTemperature(20);
    		snowDao.update(snow);
    		stateDao.update(state);
    		windDao.update(wind);
    		waveDao.update(wave);
    		weatherDao.update(weather);
    		System.out.println("snow find :" + snowDao.findById(snow.getIdSnow()).toString());
    		System.out.println("state find :" + stateDao.findById(state.getIdState()).toString());
    		System.out.println("wind find :" + windDao.findById(wind.getIdWind()).toString());
    		System.out.println("wave find :" + waveDao.findById(wave.getIdWave()).toString());
    		System.out.println("weather find :" + weatherDao.findById(weather.getIdWeather()).toString());
    		weatherDao.delete(weather);
    		snowDao.delete(snow);
    		stateDao.delete(state);
    		windDao.delete(wind);
    		waveDao.delete(wave);
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
    		 PlaceDao parisDao = new PlaceDao(manager);
             parisDao.create(paris);
             
             Snow snow = new Snow("low");
     		SnowDao snowDao = new SnowDao(manager);
     		State state = new State("rain");
     		StateDao stateDao = new StateDao(manager);
     		Wind wind = new Wind("low");
     		WindDao windDao = new WindDao(manager);
     		Wave wave = new Wave("low");
     		WaveDao waveDao = new WaveDao(manager);
     		snowDao.create(snow);
     		stateDao.create(state);
     		windDao.create(wind);
     		waveDao.create(wave);
     		Weather weather1 = new Weather(28,state,snow,wind,wave);
     		WeatherDao weatherDao = new WeatherDao(manager);
     		weatherDao.create(weather1);
     		Weather weather2 = new Weather(10,state,snow,wind,wave);
     		weatherDao.create(weather2);
     		List<Weather> weathers = new ArrayList<Weather>();
     		;
     		weathers.add(weather1);
     		weathers.add(weather2);
     		
     		List<Place> places = new ArrayList<Place>();
     		places.add(paris);
     		
    		Activity tennis = new Activity ("tennis", places,weathers);
    		ActivityDao tennisDao =	 new ActivityDao(manager);
    		tennisDao.create(tennis);
    		
    	}
    }
    
    private void listActivity() {
        List<Activity> resultList = manager.createQuery("Select a From Activity a", Activity.class).getResultList();
        System.out.println("num of activity:" + resultList.size());
        for (Activity next : resultList) {
            System.out.println("next activity: " + next);
        }
    }
    
}
