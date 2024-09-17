package org.example.mvcmeganetproject1.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mvcmeganetproject1.model.Bid;
import org.example.mvcmeganetproject1.model.City;
import org.example.mvcmeganetproject1.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j

public class BidServiceImpl implements BidService {
    private BidRepository bidRepository;
    private CityService cityService;

    @Override
    public boolean saveBid(Bid bid) {
        if (!searchStreetInCity(bid)) {
            return false;
        }

        bid.setConnectable(true);
        bidRepository.save(bid);
        return true;
    }

    public Boolean searchStreetInCity(Bid bid) {
        Optional<City> cityOptional = cityService.findCityByName(bid.getCity());

        if (cityOptional.isEmpty()) {
            return false;
        }
        log.info(bid.toString() + " bid");

        log.info(cityOptional.get().getStreets().toString());
        City city = cityOptional.get();
        boolean s = cityService.searchStreetInCity(city, bid.getStreetAddress());
        return s;
    }


    @Override
    public List<Bid> findAllBids() {
        return bidRepository.findAll();
    }
}
