package com.example.service;

import com.example.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeverForgive on 2017-03-22.
 */
@Service
public class LibraryService {

    public Library create(Library library){

        return getLibrary(library);
    }


    public List<Library> read(){
        return getList();
    }




    private List<Library> getList(){
        List<Library> list = new ArrayList<>();
        Library library = new Library(1L, "Romeo And Juliet", Library.Genre.Romance);
        list.add(library);

        return list;
    }


    private Library getLibrary(Library library){
        return new Library(library.getId(), library.getBookName(), library.getGenre());
    }

}
