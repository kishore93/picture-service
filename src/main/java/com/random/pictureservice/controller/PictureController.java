package com.random.pictureservice.controller;

import com.random.pictureservice.entity.PicsumInfoEntity;
import com.random.pictureservice.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.random.pictureservice.util.PictureUtils.seedDataIntoTemplate;

@Controller
public class PictureController {

    private final PictureService pictureService;

    @Autowired
    PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    @ResponseBody
    public String defaultHome() {
        return seedDataIntoTemplate(pictureService.getRandomPicture());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getImageById(@PathVariable(name = "id")String id) {
        return seedDataIntoTemplate(pictureService.getRandomPictureById(id));
    }

    @GetMapping(value = "/images", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<PicsumInfoEntity> getAllStoredImages() {
        return pictureService.getAllStoredPictures();
    }

}
