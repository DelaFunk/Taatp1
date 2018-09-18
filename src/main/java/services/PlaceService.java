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

import dao.PlaceDao;
import enties.Place;

import javax.persistence.EntityManager;
import jpa.EntityManagerHelper;

@Path("/places")
public class PlaceService {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Place getPlace(@PathParam("id") Long id){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		PlaceDao dao = new PlaceDao(manager);
		Place place = dao.findById(id);
		return place;
	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(Place place){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		PlaceDao dao = new PlaceDao(manager);
		dao.create(place);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePlace(@PathParam("id") Long id, Place place){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		PlaceDao dao = new PlaceDao(manager);
		if(dao.findById(id) == null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{
			dao.update(place);
			return Response.ok().build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletePlace(@PathParam("id") Long id){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		PlaceDao dao = new PlaceDao(manager);
		Place place = dao.findById(id);
		dao.delete(place);
		if(dao.findById(id) != null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{			
			return Response.ok().build();
		}
	}
	
	
}
