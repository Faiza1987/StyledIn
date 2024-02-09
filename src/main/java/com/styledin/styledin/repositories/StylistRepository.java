package com.styledin.styledin.repositories;

import com.styledin.styledin.models.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface StylistRepository extends JpaRepository<Stylist, Long> {
    @Override
    Optional<Stylist> findById(Long id);
}
