package voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import voiture.model.V_AnnonceUtilisateur;
import voiture.model.V_Marqueplusvendu;
import voiture.service.V_MarqueplusvenduService;

import java.util.List;

@RestController
@RequestMapping("/V_Marqueplusvendu")
public class V_MarqueplusvenduController {

    public final V_MarqueplusvenduService v_marqueplusvenduService;

    @Autowired
    public V_MarqueplusvenduController(V_MarqueplusvenduService v_marqueplusvenduService) {
        this.v_marqueplusvenduService = v_marqueplusvenduService;
    }

    @GetMapping("/getMarqueplusvendu")
    @PreAuthorize("hasRole('ADMIN')")
    public List<V_Marqueplusvendu> getMarqueplusvendu(){
        return v_marqueplusvenduService.getMarqueplusvendu();
    }
}
