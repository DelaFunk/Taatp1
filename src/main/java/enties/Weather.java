package enties;

public class Weather {
	
	private long idWeather;
	private float temperature;
	private long idState;
	private long idSnow;
	private long idWind;
	private long idWave;
	
	public Weather(long idWeather, float temperature, long idState, long idSnow, long idWind, long idWave) {
		super();
		this.idWeather = idWeather;
		this.temperature = temperature;
		this.idState = idState;
		this.idSnow = idSnow;
		this.idWind = idWind;
		this.idWave = idWave;
	}
	
	public long getIdWeather() {
		return idWeather;
	}
	
	public void setIdWeather(long idWeather) {
		this.idWeather = idWeather;
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	
	public long getIdState() {
		return idState;
	}
	
	public void setIdState(long idState) {
		this.idState = idState;
	}
	
	public long getIdSnow() {
		return idSnow;
	}
	
	public void setIdSnow(long idSnow) {
		this.idSnow = idSnow;
	}
	
	public long getIdWind() {
		return idWind;
	}
	
	public void setIdWind(long idWind) {
		this.idWind = idWind;
	}
	
	public long getIdWave() {
		return idWave;
	}
	
	public void setIdWave(long idWave) {
		this.idWave = idWave;
	}
	
	
}


