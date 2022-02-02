package com.user.app.controller;



import com.user.app.entity.Addresses;

import com.user.app.entity.LocationTree;
import com.user.app.repository.AddressRepo;

import com.user.app.repository.LocationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddreessController {
    private final AddressRepo addressRepo;
    private final LocationRepo locationRepo;

    @Autowired
    public AddreessController(AddressRepo addressRepo, LocationRepo locationRepo) {
        this.addressRepo = addressRepo;
        this.locationRepo = locationRepo;
    }


    @PostMapping
    public ResponseEntity<Addresses> create(@RequestBody Addresses book) {
        Optional<LocationTree> optionalLibrary = locationRepo.findById(book.getLocationTree().getLocationId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLocationTree(optionalLibrary.get());

        Addresses savedBook = addressRepo.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedBook.getAddreesInfoId()).toUri();

        return ResponseEntity.created(location).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@RequestBody  Addresses book, @PathVariable Integer id) {
        Optional<LocationTree> optionalLibrary = locationRepo.findById(book.getLocationTree().getLocationId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Addresses> optionalBook = addressRepo.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        book.setLocationTree(optionalLibrary.get());
        book.setAddreesInfoId(optionalBook.get().getAddreesInfoId());
        addressRepo.save(book);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id) {
        Optional<Addresses> optionalBook = addressRepo.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        addressRepo.delete(optionalBook.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Addresses>> getAll(Pageable pageable) {
        return ResponseEntity.ok(addressRepo.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addresses> getById(@PathVariable Integer id) {
        Optional<Addresses> optionalBook = addressRepo.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalBook.get());
    }
}
