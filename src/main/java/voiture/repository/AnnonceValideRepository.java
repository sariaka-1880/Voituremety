package voiture.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voiture.model.AnnonceValide;

@Repository
public interface AnnonceValideRepository extends JpaRepository<AnnonceValide, Integer> {


}
