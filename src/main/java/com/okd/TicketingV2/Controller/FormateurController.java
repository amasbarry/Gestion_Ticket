package com.okd.TicketingV2.Controller;

import com.okd.TicketingV2.Modele.Formateur;
import com.okd.TicketingV2.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formateurs")

public class FormateurController {

    @Autowired
    private FormateurService formateurService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // endpoint recuperer tous les formateurs
    @GetMapping
    public List<Formateur> getAllFormateurs() {
        return formateurService.getAllFormateurs();
    }

    //endpoint pour recuperer un formateur par id
    @GetMapping("/{id}")
    public ResponseEntity<Formateur> getFormateurById(@PathVariable Long id) {
        Optional<Formateur> formateur = formateurService.getFormateurById(id);
        return formateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // Endpoint pour créer un formateur
    @PostMapping("/create")
    public ResponseEntity<Formateur> createFormateur(@RequestBody Formateur formateur) {
        Formateur createdFormateur = formateurService.createFormateur(formateur);
        formateur.setMotDePasse(passwordEncoder.encode(formateur.getMotDePasse()));
        return new ResponseEntity<>(createdFormateur, HttpStatus.CREATED);
    }

    // Endpoint pour modifier un formateur
    @PutMapping("/{id}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long id, @RequestBody Formateur formateurDetails) {
        try {
            Formateur updatedFormateur = formateurService.updateFormateur(id, formateurDetails);
            String encodedPassword = passwordEncoder.encode(formateurDetails.getMotDePasse());
            updatedFormateur.setMotDePasse(encodedPassword);
            return new ResponseEntity<>(updatedFormateur, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un formateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormateur(@PathVariable Long id) {
        formateurService.deleteFormateurById(id);
        return ResponseEntity.noContent().build();
    }


}
