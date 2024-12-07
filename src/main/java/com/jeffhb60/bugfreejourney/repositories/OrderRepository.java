package com.jeffhb60.bugfreejourney.repositories;

import com.jeffhb60.bugfreejourney.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
