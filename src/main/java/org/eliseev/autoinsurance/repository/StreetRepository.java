package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.sub.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
}
