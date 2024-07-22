package com.barber.barber_service.repository;

import com.barber.barber_service.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BarberRepository extends JpaRepository<Barber, Long> {
    Optional<Barber> findByEmail(String email);
}
