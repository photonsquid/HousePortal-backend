package houseportal;
import java.util.*;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class Facade {
	
	@PersistenceContext
	private EntityManager em;
	
	public Collection<User> listUsers(){
		//return (Collection<Personne>) (personne.values());
		TypedQuery<User> req = em.createQuery("select c from User c",
				User.class);
		return req.getResultList();
	}
	
	public Collection<Device> listeDevice(){
		TypedQuery<Device> req = em.createQuery("select c from Device c",
				Device.class);
		return req.getResultList();
	}
	
	public void addUser(String username, String mail) {
		User user = new User(username,mail);

		em.persist(user);
	}
	
	public void addDevice(int ip_address, String name, String type) {
		Device device= new Device(ip_address,name,type);
		em.persist(device);
	}
	
}
