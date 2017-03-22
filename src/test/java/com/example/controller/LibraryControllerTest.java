package com.example.controller;

import com.example.model.Library;
import com.example.service.LibraryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeverForgive on 2017-03-22.
 */
public class LibraryControllerTest extends AbstractControllerTest {

    @Mock
    private LibraryService libraryService;

    private LibraryController controller;

    @Before
    public void setUp(){
       controller =  new LibraryController(libraryService);
       super.setUp(controller);
    }

    @Test
    public void createTest() throws Exception {
        Library library = getLibrary();

        String libraryAsString = mapToJson(library);

        Mockito.when(libraryService.create(Matchers.anyObject())).thenReturn(library);

        String uri = "/api/library";

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                    .post(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(libraryAsString)
        ).andReturn();

        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();

        Library createdLibrary = mapFromJson(content, Library.class);

        Mockito.verify(libraryService, Mockito.times(1)).create(Matchers.anyObject());

        Assert.assertEquals(1L, createdLibrary.getId());
        Assert.assertEquals("Romeo And Juliet", createdLibrary.getBookName());
        Assert.assertEquals(Library.Genre.Romance, createdLibrary.getGenre());
        Assert.assertEquals(201, status);


    }

    @Test
    public void readTest() throws Exception {
        List<Library> list = getList();

        String uri ="/api/library";

        Mockito.when(libraryService.read()).thenReturn(list);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();

        Assert.assertTrue(content.trim().length() > 0);
        Assert.assertEquals(200, status);





    }



    private List<Library> getList(){
        List<Library> list = new ArrayList<>();
        Library library = getLibrary();
        list.add(library);

        return list;
    }


    private Library getLibrary(){
        return new Library(1L, "Romeo And Juliet", Library.Genre.Romance);
    }



}
