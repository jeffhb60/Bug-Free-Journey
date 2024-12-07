package com.jeffhb60.bugfreejourney.repositories;

import com.jeffhb60.bugfreejourney.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
