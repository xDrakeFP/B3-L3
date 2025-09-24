package federicopini;

import dao.*;
import entities.*;
import enums.Sesso;
import enums.StatoPartecipazione;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("B3-L3");
        EntityManager em = emf.createEntityManager();

        PersonaDAO pd = new PersonaDAO(em);
        LocationDAO ld = new LocationDAO(em);
        EventoDAO ed = new EventoDAO(em);
        PartecipazioneDAO pad = new PartecipazioneDAO(em);

        Persona mario = new Persona("mario","Rossi","mario.rossi@gmail.com", LocalDate.of(1999,5,10), Sesso.MASCHIO);

        pd.save(mario);

        Location roma = new Location("Stadio Olimpico", "Roma");
        ld.save(roma);

        Evento eventoRoma = new Evento("Scudetto Roma",LocalDate.of(2000, 01, 01),"Forza Roma", TipoEvento.PUBBLICO,10000);
        eventoRoma.setLocation(roma);

        ed.save(eventoRoma);

        Partecipazione p = new Partecipazione(mario, eventoRoma, StatoPartecipazione.DA_CONFERMARE);
        pad.save(p);

        em.close();
        emf.close();

    }
}
