package com.okd.TicketingV2.Controller;

import com.okd.TicketingV2.Modele.Admin;
import com.okd.TicketingV2.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TOUS LES ADMIN
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    //par Id
    @GetMapping("/{id}")

    public ResponseEntity<Admin> getAdminById(@PathVariable Long id){
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //creer
    @PostMapping

    public Admin createAdmin(@RequestBody Admin admin){
        admin.setMotDePasse(passwordEncoder.encode(admin.getMotDePasse()));
        return adminService.createAdmin(admin);
    }
    // Mettre à jour un admin par ID

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Admin admin = adminService.updateAdmin(id, updatedAdmin);
        String encodedPassword = passwordEncoder.encode(updatedAdmin.getMotDePasse());
        admin.setMotDePasse(encodedPassword);
        return ResponseEntity.ok(admin);
    }

    // Supprimer un admin par ID

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
