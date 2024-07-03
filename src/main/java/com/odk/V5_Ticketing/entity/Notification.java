package com.odk.V5_Ticketing.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private LocalDate dateEnvoi;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
