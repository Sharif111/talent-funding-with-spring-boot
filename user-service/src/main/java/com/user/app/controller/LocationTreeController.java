package com.user.app.controller;

import com.user.app.dto.LocationTreeDto;
import com.user.app.entity.LocationTree;
import com.user.app.repository.AddressRepo;

import com.user.app.repository.LocationRepo;
import com.user.app.responseModel.CommonResposeModel;
import com.user.app.service.LocationTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locationTrees")
public class LocationTreeController {

    private final LocationRepo locationRepo;
    private final AddressRepo addressRepo;

    @Autowired
    private LocationTreeService  locationTreeService;

    @Autowired
    public LocationTreeController(LocationRepo locationRepo, AddressRepo addressRepo) {
        this.locationRepo = locationRepo;
        this.addressRepo = addressRepo;
    }



    @PostMapping("/add-locaiton")
    public CommonResposeModel addLocation(@RequestBody LocationTreeDto locationTree) {
        return locationTreeService.save(locationTree);

    }





    @PostMapping
    public ResponseEntity<LocationTree> create(@RequestBody LocationTree library) {
        LocationTree savedLibrary = locationRepo.save(library);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedLibrary.getLocationId()).toUri();

        return ResponseEntity.created(location).body(savedLibrary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationTree> update(@PathVariable Integer id,  @RequestBody LocationTree library) {
        Optional<LocationTree> optionalLibrary = locationRepo.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        library.setLocationId(optionalLibrary.get().getLocationId());
        locationRepo.save(library);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LocationTree> delete(@PathVariable Integer id) {
        Optional<LocationTree> optionalLibrary = locationRepo.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        locationRepo.delete(optionalLibrary.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationTree> getById(@PathVariable Integer id) {
        Optional<LocationTree> optionalLibrary = locationRepo.findById(id);
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalLibrary.get());
    }

    @GetMapping
    public ResponseEntity<Page<LocationTree>> getAll(Pageable pageable) {
        return ResponseEntity.ok(locationRepo.findAll(pageable));
    }
}
