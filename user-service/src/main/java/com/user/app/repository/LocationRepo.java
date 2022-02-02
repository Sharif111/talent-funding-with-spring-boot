package com.user.app.repository;

import com.user.app.entity.LocationTree;
import com.user.app.entity.LocationTreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<LocationTree,Integer> {

}
