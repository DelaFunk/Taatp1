package enties;

import javax.persistence.Entity;

@Entity
public class Activity {
	private Long idActivity;
	private String label;
	private list <Weather> listWeather;
	public Activity() {
		super();
	}
	
	public Activity(Long idActivity, String label) {
		this.idActivity=idActivity;
		this.label=label;
	}

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
	
	@Override
    public String toString() {
        return "Activity [idActivity=" + idActivity + ", label=" + label + ", Weather="
                + listWeather.toString + "]";
    }
	
	
	
}