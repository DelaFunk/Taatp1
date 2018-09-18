package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.WeatherDao;
import enties.Weather;

import javax.persistence.EntityManager;
import jpa.EntityManagerHelper;


@Path("/weather")
public class WeatherService {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Weather getWeather(@PathParam("id") Long id) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		WeatherDao weatherDao = new WeatherDao(manager);
		Weather weather = weatherDao.findById(id);
		return weather;
	}

	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addWeather(Weather weather) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		WeatherDao weatherDao = new WeatherDao(manager);
		weatherDao.create(weather);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWeather(@PathParam("id") Long id, Weather weather) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		WeatherDao weatherDao = new WeatherDao(manager);
		if(weatherDao.findById(id) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else {
			weatherDao.update(weather);
			return Response.ok().build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteWeather (@PathParam("id") Long id) {
		EntityManager manager = EntityManagerHelper.getEntityManager();
		WeatherDao weatherDao = new WeatherDao(manager);
		Weather weather = weatherDao.findById(id);
		weatherDao.delete(weather);
		if(weatherDao.findById(id) != null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else {
			return Response.ok().build();
		}
	}
	

}
