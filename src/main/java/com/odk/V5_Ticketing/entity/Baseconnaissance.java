package com.odk.V5_Ticketing.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.net.URL;

@Entity
@Data

public class Baseconnaissance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String categori;
    private URL reponse;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

}
