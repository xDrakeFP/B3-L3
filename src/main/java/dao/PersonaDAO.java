package dao;

import entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em){
        this.em = em;
    }

    public void save(Persona persona){
        EntityTransaction pt = em.getTransaction();
        pt.begin();
        em.persist(persona);
        pt.commit();
    }
    public Persona findById (UUID id){
        return em.find(Persona.class, id);
    }
}
