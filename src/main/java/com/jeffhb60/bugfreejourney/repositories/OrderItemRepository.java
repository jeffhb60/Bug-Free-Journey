package com.jeffhb60.bugfreejourney.repositories;

import com.jeffhb60.bugfreejourney.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
