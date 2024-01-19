package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import voiture.model.Photo;
import voiture.repository.PhotoRepository;

import java.io.IOException;

@Service
public class PhotoService {
    public final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void insertPhoto(MultipartFile file, Integer maxid) throws IOException {
        byte[] data = file.getBytes();
        Photo photo= new Photo();
        photo.setNomphoto(data);
        photo.setId_Annonceutilisateur(maxid);
        photoRepository.save(photo);
    }
}