package org.example.mvcmeganetproject1.service;


import org.example.mvcmeganetproject1.model.Bid;

import java.util.List;

public interface BidService {
    void saveBid(Bid bid);
    List<Bid> findAllBids();
}
