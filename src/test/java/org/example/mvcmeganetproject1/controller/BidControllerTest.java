package org.example.mvcmeganetproject1.controller;

import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.service.BidService;
import org.example.mvcmeganetproject1.service.CityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BidController.class)
class BidControllerTest {

    @MockBean
    private BidService bidService;

    @MockBean
    private CityService cityService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("")
    void showBidForm() throws Exception {
        mockMvc.perform(get("/bid"))
                .andExpect(status().isOk())
                .andExpect(view().name("bid-form"))
                .andExpect(model().attributeExists("bid"));
    }

    @Test
    @DisplayName("")
    void submitBid() throws Exception {
        Bid bid = new Bid();
        bid.setId(1);
        bid.setCity("Москва");
        bid.setStreetAddress("Ленина");

        City city = new City();
        city.setId(1);
        city.setName("Москва");

        Mockito.when(cityService.findCityByName("Москва")).thenReturn(Optional.of(city));
        Mockito.when(cityService.searchStreetInCity(city,"Ленина")).thenReturn(true);

        mockMvc.perform(post("/bid")
                .flashAttr("bid", bid))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));

        Mockito.verify(bidService, Mockito.times(1)).saveBid(any(Bid.class));

    }

    @Test
    void getAllBids() {
    }
}