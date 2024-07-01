package com.okd.TicketingV2.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Admin extends Utilisateur {

    @JsonIgnore
    @OneToMany
    private List<Formateur> formateurs;

    @JsonIgnore
    @OneToMany
    private List<Apprenant> apprenants;

}
