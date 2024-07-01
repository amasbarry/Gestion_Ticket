package com.okd.TicketingV2.Controller;


import com.okd.TicketingV2.Modele.Apprenant;
import com.okd.TicketingV2.Service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenants")

public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //endpoint pour recuperer tous les apprenants
    @GetMapping
    public List<Apprenant> getAllApprenants() {
        return apprenantService.getAllApprenant();
    }
    //Endpoind pour recuperer un apprenant par id
    @GetMapping("/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = apprenantService.getApprenant(id);
        return apprenant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //endpoint pour ajouter un nouvel apprenant
    @PostMapping("/create")
    public Apprenant add(@RequestBody Apprenant apprenant) {
        apprenant.setMotDePasse(passwordEncoder.encode(apprenant.getMotDePasse()));
        return apprenantService.addApprenant(apprenant);
    }
    //endpoint pour mettre a jour un apprenant existant
    @PutMapping("/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenantDetails) {
        try {
            Apprenant updatedApprenant = apprenantService.updateApprenant(id, apprenantDetails);
            String encodedPassword = passwordEncoder.encode(apprenantDetails.getMotDePasse());
            updatedApprenant.setMotDePasse(encodedPassword);
            return ResponseEntity.ok(updatedApprenant);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    //endpoint pour supprimer un apprenant par id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }
}
