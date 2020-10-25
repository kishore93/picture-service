package com.random.pictureservice.service;

import com.random.pictureservice.entity.PicsumInfoEntity;
import com.random.pictureservice.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    String picsumUrlTemplate = "https://picsum.photos/id/{{id}}/info";

    @Autowired
    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public PicsumInfoEntity getRandomPicture() {

        ResponseEntity<PicsumInfoEntity> responseEntity = new RestTemplate()
                .getForEntity(picsumUrlTemplate.replace("{{id}}", String.valueOf(new Random().nextInt(1084))),
                        PicsumInfoEntity.class);

        PicsumInfoEntity data = responseEntity.getBody();
        return data;

    }

    public PicsumInfoEntity getRandomPictureById(String id) {
        Optional<PicsumInfoEntity> entity = this.getPictureById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        PicsumInfoEntity randomPicture = getRandomPicture();
        randomPicture.setId(id);
        pictureRepository.save(randomPicture);
        return randomPicture;
    }

    public Optional<PicsumInfoEntity> getPictureById(String id) {
        return pictureRepository.findById(id);
    }

    public List<PicsumInfoEntity> getAllStoredPictures() {
        return pictureRepository.findAll();
    }
}
