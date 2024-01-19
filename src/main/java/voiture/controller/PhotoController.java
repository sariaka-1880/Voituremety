package voiture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import voiture.service.PhotoService;

import java.io.IOException;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    public final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @PostMapping("/insertPhoto")
    public ResponseEntity<String> insertPhoto(@RequestParam("file") MultipartFile file, @RequestParam Integer maxid){
        try{
                photoService.insertPhoto(file,maxid);
                return ResponseEntity.ok("Image successfully imported");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Image successfully imported");
        }
    }
}
