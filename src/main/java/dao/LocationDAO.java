package dao;

import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private EntityManager em;
     public LocationDAO(EntityManager em) {
         this.em = em;
     }

     public void save(Location location){
         EntityTransaction lt = em.getTransaction();
         lt.begin();
         em.persist(location);
         lt.commit();
     }

     public Location findById(UUID id){
         return em.find(Location.class, id);
     }

}
