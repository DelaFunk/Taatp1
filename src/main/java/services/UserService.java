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

import dao.UserDao;
import enties.User;

import javax.persistence.EntityManager;
import jpa.EntityManagerHelper;

@Path("/users")
public class UserService {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") String id){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		UserDao dao = new UserDao(manager);
		User user = dao.findById(Long.parseLong(id));
		return user;
	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		
		UserDao dao = new UserDao(manager);
		dao.create(user);
		
		return Response.ok().build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") String id, User user){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		UserDao dao = new UserDao(manager);
		if(dao.findById(Long.parseLong(id)) == null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{
			dao.update(user);
			return Response.ok().build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") String id){
		EntityManager manager = EntityManagerHelper.getEntityManager();
		UserDao dao = new UserDao(manager);
		User user = dao.findById(Long.parseLong(id));
		dao.delete(user);
		if(dao.findById(Long.parseLong(id)) != null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{			
			return Response.ok().build();
		}
	}
	
}
