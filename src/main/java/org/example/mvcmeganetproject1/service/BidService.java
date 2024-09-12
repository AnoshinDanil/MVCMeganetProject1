package org.example.mvcmeganetproject1.service;


import org.example.mvcmeganetproject1.model.Bid;

import java.util.List;

public interface BidService {
    boolean saveBid(Bid bid);
    List<Bid> findAllBids();
}
