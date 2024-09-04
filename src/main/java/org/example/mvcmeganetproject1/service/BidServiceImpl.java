package org.example.mvcmeganetproject1.service;


import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public void saveBid(Bid bid) {
        bidRepository.save(bid);
    }

    @Override
    public List<Bid> findAllBids() {
        return bidRepository.findAll();
    }
}
