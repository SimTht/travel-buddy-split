package com.tbs.travel_buddy_split.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbs.travel_buddy_split.domain.entity.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByOwnerId(Long ownerId);
}