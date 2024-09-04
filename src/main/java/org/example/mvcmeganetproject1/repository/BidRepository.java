package org.example.mvcmeganetproject1.repository;


import org.example.mvcmeganetproject1.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

}
