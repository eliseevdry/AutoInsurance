package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.sub.PassportOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportOfficeRepository extends JpaRepository<PassportOffice, Long> {
}
