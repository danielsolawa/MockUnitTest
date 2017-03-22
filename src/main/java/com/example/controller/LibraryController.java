package com.example.controller;

import com.example.model.Library;
import com.example.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by NeverForgive on 2017-03-22.
 */
@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    //Create method
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Library> create(@RequestBody Library library){
        Library createdLibrary = libraryService.create(library);

        return new ResponseEntity<Library>(createdLibrary, HttpStatus.CREATED);
    }

    //Read method
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Library>> read(){
        List<Library> list = libraryService.read();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }






}
