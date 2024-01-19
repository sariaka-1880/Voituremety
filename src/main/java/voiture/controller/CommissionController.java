package voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import voiture.model.Commission;
import voiture.model.Marque;
import voiture.model.V_AnnonceUtilisateur;
import voiture.service.CommissionService;

import java.util.List;

@RestController
@RequestMapping("/commission")
public class CommissionController {

    private final CommissionService commissionService;

    @Autowired
    public CommissionController(CommissionService commissionService) { this.commissionService = commissionService; }

    @GetMapping("/getLastCommission")
    @PreAuthorize("hasRole('ADMIN')")
    public Commission getLastCommission() {
        return commissionService.getLastCommission();
    }
}
