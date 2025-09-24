package entities;

import enums.StatoPartecipazione;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Partecipazione {
    @Id
    @Column (name = "partecipazione_id")
    @GeneratedValue
    private UUID idPartecipazione;

    @ManyToOne
    @JoinColumn
    private Persona persona;

    @ManyToOne
    @JoinColumn
    private Evento evento;

    @Column
    @Enumerated
    private StatoPartecipazione statoPartecipazione;

    public Partecipazione() {}

    public Partecipazione(Persona persona, Evento evento, StatoPartecipazione statoPartecipazione) {
        this.persona = persona;
        this.evento = evento;
        this.statoPartecipazione = statoPartecipazione;
    }

    public UUID getIdPartecipazione() {
        return idPartecipazione;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

}
