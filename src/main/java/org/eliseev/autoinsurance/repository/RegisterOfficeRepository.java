package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.sub.RegisterOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterOfficeRepository extends JpaRepository<RegisterOffice, Long> {
}
