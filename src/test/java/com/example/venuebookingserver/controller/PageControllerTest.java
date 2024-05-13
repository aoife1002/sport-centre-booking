package com.example.venuebookingserver.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageControllerTest {

    @InjectMocks
    private PageController pageController;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        model = new BindingAwareModelMap();
    }

    @Test
    void toLogin() {
        String view = pageController.toLogin();
        assertEquals("login", view);
    }

    @Test
    void toError() {
        String view = pageController.toError();
        assertEquals("error", view);
    }

    @Test
    void toRegister() {
        String view = pageController.toRegister();
        assertEquals("register", view);
    }

    @Test
    void toIndex() {
        String view = pageController.toIndex(request, response, model);
        assertEquals("login", view);
    }
}

