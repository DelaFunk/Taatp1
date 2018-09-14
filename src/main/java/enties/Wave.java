package enties;

public class Wave {
	
	private long idWave;
	private String label;
	
	public Wave(long idWave, String label) {
		super();
		this.idWave = idWave;
		this.label = label;
	}

	public long getIdWave() {
		return idWave;
	}

	public void setIdWave(long idWave) {
		this.idWave = idWave;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	

}
