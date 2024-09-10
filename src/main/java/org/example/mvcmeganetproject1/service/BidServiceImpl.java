package org.example.mvcmeganetproject1.service;


import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private CityService cityService;

    @Override
    public void saveBid(Bid bid) {
        Optional<City> cityOptional = cityService.findCityByName(bid.getCity());

        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            boolean streetExists = cityService.searchStreetInCity(city, bid.getStreetAddress());
            System.out.println("Street exists: " + streetExists);
            bid.setConnectable(streetExists);
        } else {
            System.out.println("City not found: " + bid.getCity());
            bid.setConnectable(false);
        }

        bidRepository.save(bid);
    }

    @Override
    public List<Bid> findAllBids() {
        return bidRepository.findAll();
    }
}
