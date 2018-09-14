package enties;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Activity {
	private Long idActivity;
	private String label;
	private ArrayList <Weather> weathers = new ArrayList <Weather>();
	private ArrayList <User> users = new ArrayList <User>();
	private ArrayList <Place> places = new ArrayList <Place>();
	public Activity() {
		super();
	}


	public Activity(Long idActivity, String label) {
		this.idActivity=idActivity;
		this.label=label;
	}


	@Id
	@GeneratedValue
	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	@ManyToMany
	@JoinTable(name="ActivityWeather",
	joinColumns= { @JoinColumn(name = "idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idWeather")})
	public ArrayList<Weather> getWeathers() {
		return weathers;
	}




	public void setWeathers(ArrayList<Weather> weathers) {
		this.weathers = weathers;
	}


	@ManyToMany
	@JoinTable(name="ActivityUser",
	joinColumns= { @JoinColumn(name = "idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idUser")})
	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	@ManyToMany
	@JoinTable(name="ActivityPlace",
	joinColumns= {@JoinColumn(name="idActivity")},
	inverseJoinColumns= {@JoinColumn(name = "idPlace")})
	public ArrayList<Place> getPlaces() {
		return places;
	}


	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}


	@Override
	public String toString() {
		return "Activity [idActivity=" + idActivity + ", label=" + label + ", Weathers="
				+ weathers.toString() + "]";
	}




}