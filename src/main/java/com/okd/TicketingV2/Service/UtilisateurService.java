package com.okd.TicketingV2.Service;

import com.okd.TicketingV2.Modele.Utilisateur;
import com.okd.TicketingV2.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    //creer utulisateur
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Modifier un Utilisateur
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur1 = optionalUtilisateur.get();
            utilisateur1.setNom(utilisateur.getNom());
            utilisateur1.setPrenom(utilisateur.getPrenom());
            utilisateur1.setEmail(utilisateur.getEmail());
            utilisateur1.setMotDePasse(utilisateur.getMotDePasse());
            utilisateur1.setRole(utilisateur.getRole());
            return utilisateurRepository.save(utilisateur1);

        } else {
            throw new RuntimeException("utilisateur not found with id " + id);
        }
    }
    // Supprimer un Utilisateur
   public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
   }

}
