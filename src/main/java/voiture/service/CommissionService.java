package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Commission;
import voiture.repository.CommissionRepository;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commisionRepository) { this.commissionRepository = commisionRepository; }

    public Commission getLastCommission() {
        return commissionRepository.getCommisssionAnnonce();
    }
}

