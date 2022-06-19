package org.eliseev.autoinsurance.repository;

import org.eliseev.autoinsurance.model.sub.CountryArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryAreaRepository extends JpaRepository<CountryArea, String> {
}
