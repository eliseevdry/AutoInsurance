package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.sub.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}
