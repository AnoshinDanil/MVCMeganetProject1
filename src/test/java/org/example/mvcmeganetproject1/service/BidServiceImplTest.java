package org.example.mvcmeganetproject1.service;

import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.repository.BidRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;



@ExtendWith(MockitoExtension.class)
class BidServiceImplTest {

    @Mock
    private BidRepository bidRepository;

    @InjectMocks
    private BidServiceImpl bidService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Должен сохранить заявку")
    void saveBid() {
        Bid bid = new Bid();
        bid.setId(1);
        bid.setPhone("88005553535");

        bidService.saveBid(bid);

        Mockito.verify(bidRepository,Mockito.times(1)).save(bid);
    }

    @Test
    @DisplayName("Должен показывать все заявки")
    void findAllBids() {
        Bid bid1 = new Bid();
        bid1.setId(1);
        bid1.setPhone("88005553535");

        Bid bid2 = new Bid();
        bid2.setId(2);
        bid2.setPhone("78005553535");

        List<Bid> mockBids = Arrays.asList(bid1, bid2);
        Mockito.when(bidRepository.findAll()).thenReturn(mockBids);

        List<Bid> allBids = bidService.findAllBids();

        Assertions.assertEquals(2, allBids.size());
        Assertions.assertEquals(bid2.getPhone(), allBids.get(1).getPhone());

        Mockito.verify(bidRepository, Mockito.times(1)).findAll();
    }
}