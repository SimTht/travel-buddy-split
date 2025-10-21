package com.tbs.travel_buddy_split.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbs.travel_buddy_split.domain.entity.ExpenseShare;

@Repository
public interface ExpenseShareRepository extends JpaRepository<ExpenseShare, Long> {
    List<ExpenseShare> findByExpenseId(Long expenseId);
    List<ExpenseShare> findByUserId(Long userId);
    Optional<ExpenseShare> findByExpenseIdAndUserId(Long expenseId, Long userId);
}

