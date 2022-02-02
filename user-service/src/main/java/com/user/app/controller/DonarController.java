package com.user.app.controller;

import com.user.app.model.DonarDto;
import com.user.app.service.DonarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DonarController {

    @Autowired
    private DonarService donarService;

    // create donar rest api
    @PostMapping("/donars")
    public ResponseEntity<DonarDto> createDonar(@RequestBody DonarDto donarDto){
        return new ResponseEntity<>(donarService.createDonar(donarDto), HttpStatus.CREATED);
    }
}
