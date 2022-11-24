package com.example.masterRobot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface storeItemRepository extends JpaRepository<store_items, Long> {

}
