package com.tbs.travel_buddy_split.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbs.travel_buddy_split.domain.entity.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByTripId(Long tripId);
}


