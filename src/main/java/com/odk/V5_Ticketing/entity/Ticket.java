package com.odk.V5_Ticketing.entity;

import com.odk.V5_Ticketing.Enum.CategoriTicket;
import com.odk.V5_Ticketing.Enum.EtatTicket;
import com.odk.V5_Ticketing.Enum.Urgence;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @Enumerated(EnumType.STRING)
    private Urgence urgence;
    @Enumerated(EnumType.STRING)
    private CategoriTicket categori;
    @Enumerated(EnumType.STRING)
    private EtatTicket etat;

    private LocalDate dateCreation;

    private LocalDate dateResolution;

    @ManyToOne(cascade = CascadeType.PERSIST) // Assurez-vous que le fetch type est correct
    @JoinColumn(name = "apprenant_id")

    private Apprenant apprenant;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

}
