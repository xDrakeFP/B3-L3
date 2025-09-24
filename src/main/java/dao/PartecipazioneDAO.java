package dao;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioneDAO {
    private EntityManager em;
    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione){
        EntityTransaction pt = em.getTransaction();
        pt.begin();
        em.persist(partecipazione);
        pt.commit();
    }

    public Partecipazione findById(UUID id){
        return em.find(Partecipazione.class, id);
    }

}