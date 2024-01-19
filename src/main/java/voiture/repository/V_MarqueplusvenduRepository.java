package voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import voiture.model.V_AnnonceFavorisUtilisateur;
import voiture.model.V_Marqueplusvendu;
import java.util.List;

@Repository
public interface V_MarqueplusvenduRepository extends JpaRepository<V_Marqueplusvendu,Integer>  {

    @Query(value = "select * from V_Marqueplusvendu;", nativeQuery = true)
    List<V_Marqueplusvendu> getMarqueplusvendu();
}
