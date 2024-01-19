package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.model.V_HistoriqueAchat;

@Repository
public interface V_HistoriqueAchatRepository extends JpaRepository<V_HistoriqueAchat,Integer>  {

    @Query(value = "select count(id_annonceutilisateur) as nbvente,sum(commission) as chiffre_daffaire from V_HistoriqueAchat", nativeQuery = true)
    V_HistoriqueAchat getChiffreDAffaire();
}
