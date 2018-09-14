package enties;

public class Wind {
	
	private long idWind;
	private String label;
	
	
	public Wind(long idWind, String label) {
		super();
		this.idWind = idWind;
		this.label = label;
	}


	public long getIdWind() {
		return idWind;
	}


	public void setIdWind(long idWind) {
		this.idWind = idWind;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
}
