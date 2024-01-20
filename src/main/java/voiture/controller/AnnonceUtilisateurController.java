package voiture.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import voiture.model.AnnonceValide;
import voiture.model.Utilisateur;
import voiture.repository.UtilisateurRepository;
import voiture.service.AnnonceValideService;
import voiture.service.AnnonceutilisateurService;
import voiture.model.Annonceutilisateur;
import voiture.service.PhotoService;
import voiture.tools.JwtUtil;


import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@RestController
@RequestMapping("/AnnonceUtilisateur")
public class AnnonceUtilisateurController {

    private final AnnonceutilisateurService annonceutilisateurService;
    private final AnnonceValideService annonceValideService;
    private final PhotoService photoService;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public AnnonceUtilisateurController(AnnonceutilisateurService annonceutilisateurService, AnnonceValideService annonceValideService, PhotoService photoService, JwtUtil jwtUtil) {
        this.annonceutilisateurService = annonceutilisateurService;
        this.annonceValideService = annonceValideService;
        this.photoService = photoService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/rechercheAvance")
    @PreAuthorize("hasRole('USER')")
    public Integer getMaxId(){
        return annonceutilisateurService.getMaxId();
    }

    @PostMapping("/AddAnnonceutilisateur")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Annonceutilisateur> AddAnnonceutilisateur(@RequestBody Annonceutilisateur annonceutilisateur) {
        Annonceutilisateur  createdAnnonceUtilisateur = annonceutilisateurService.AddAnnonceutilisateur(annonceutilisateur);
        return new ResponseEntity<>(createdAnnonceUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping("/updateStatusAnnonce")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateStatusAnnonce( @RequestParam Integer Id_Annonceutilisateur, HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        String token = authorization.substring(7);
        System.out.println("Token: " + token);
        String login = jwtUtil.extractLogin(token);

        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByLogin(login);
        Utilisateur utilisateur = new Utilisateur();

        long currentTimeMillis = System.currentTimeMillis();
        java.util.Date currentDate = new java.util.Date(currentTimeMillis);
        Date currentSqlDate = new Date(currentDate.getTime());

        if (utilisateurOptional.isPresent()) {

            utilisateur = utilisateurOptional.get();
            AnnonceValide annonceValide = new AnnonceValide();

            annonceValide.setId_Annonceutilisateur(Id_Annonceutilisateur);
            annonceValide.setDatevalidation(currentSqlDate);
            annonceValide.setId_Utilisateur(utilisateur.getIdutilisateur());

            annonceValideService.addAnnonceValide(annonceValide);
        }
        annonceutilisateurService.updateStatusAnnonce(Id_Annonceutilisateur);

    }
    @GetMapping("/updateStatusAnnonceVendu")
    @PreAuthorize("hasRole('USER')")
    public void updateStatusAnnonceVendu(@RequestParam Integer Id_Annonceutilisateur, @RequestParam Integer idutilisateur ){
        annonceutilisateurService.updateStatusAnnonceVendu(Id_Annonceutilisateur, idutilisateur);
    }



}


