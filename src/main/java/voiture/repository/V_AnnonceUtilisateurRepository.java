package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceUtilisateur;

import java.util.List;

@Repository
public interface V_AnnonceUtilisateurRepository extends JpaRepository<V_AnnonceUtilisateur,Integer> {
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=0", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceNonValide(Integer idutilisateur);
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=1", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceValide(Integer idutilisateur);
    @Query(value = "select * from V_AnnonceUtilisateur where idutilisateur=?1 and status=2", nativeQuery = true)
    List<voiture.model.V_AnnonceUtilisateur> getAnnonceValideVendu(Integer idutilisateur);

    @Query(value = "select * from V_AnnonceUtilisateur where status=0", nativeQuery = true)
    List<V_AnnonceUtilisateur> getAnnonceAValide();

    @Query(value = "select * from V_AnnonceUtilisateur where Id_Annonceutilisateur=?1", nativeQuery = true)
    List<V_AnnonceUtilisateur> getAnnonceDetail(Integer Id_Annonceutilisateur);

    @Query(value = "select * from V_AnnonceUtilisateur where status=1  and ( id_modele is not null or id_modele=?1) and (Id_couleur is not null or Id_couleur=?2) and (annee is not not null or annee = ?3) and (id_typevoiture is not null or id_typevoiture=4) and (id_marque is not null or id_marque=5) and ((prix is not null) or prix <6 and prix >7 )\n", nativeQuery = true)
    List<V_AnnonceUtilisateur> rechercheAvance(Integer id_modele,Integer id_couleur,Integer annee, Integer id_typevoiture,Integer id_marque,Double prix1,Double prix2 );




}
