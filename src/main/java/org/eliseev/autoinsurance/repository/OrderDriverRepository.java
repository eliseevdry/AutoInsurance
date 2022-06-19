package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.OrderDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDriverRepository extends JpaRepository<OrderDriver, Long> {
}
