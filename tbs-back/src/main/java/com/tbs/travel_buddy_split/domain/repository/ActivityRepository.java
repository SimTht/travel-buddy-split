package com.tbs.travel_buddy_split.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbs.travel_buddy_split.domain.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByTripId(Long tripId);
}

