package com.okd.TicketingV2.Modele;

import com.okd.TicketingV2.Enum.CategorieTicket;
import com.okd.TicketingV2.Enum.EtatTicket;
import com.okd.TicketingV2.Enum.Urgence;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @Enumerated(EnumType.STRING)
    private Urgence urgence;
    @Enumerated(EnumType.STRING)
    private CategorieTicket categorieTicket;
    @Enumerated(EnumType.STRING)
    private EtatTicket etatTicket;
    LocalDate dateCreation;
    LocalDate dateResolution;


    @ManyToOne(cascade = CascadeType.PERSIST) // Assurez-vous que le fetch type est correct
    @JoinColumn(name = "apprenant_id")

    private Apprenant apprenant;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

}
