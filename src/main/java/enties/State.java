package enties;

public class State {

	private long idState;
	private String label;
	
	public State(long idState, String label) {
		super();
		this.idState = idState;
		this.label = label;
	}

	public long getIdState() {
		return idState;
	}

	public void setIdState(long idState) {
		this.idState = idState;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
		
}
