package com.okd.TicketingV2.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Apprenant extends Utilisateur{

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @JsonIgnore
    @OneToMany
    private List<Notification> notifications;

    @JsonIgnore
    @OneToMany
    private List<Ticket> tickets;

    @ManyToOne
    private Admin admin;

}
