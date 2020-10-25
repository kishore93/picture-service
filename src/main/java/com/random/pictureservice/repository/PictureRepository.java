package com.random.pictureservice.repository;

import com.random.pictureservice.entity.PicsumInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<PicsumInfoEntity, String> {
}
