package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;
    @Column (name = "nome_evento")
    private String nome;
    @Column (name = "nome_città")
    private String citta;

    @OneToMany (mappedBy = "location")
    private List<Evento> eventi = new ArrayList<>();



    public Location(){}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }
}
