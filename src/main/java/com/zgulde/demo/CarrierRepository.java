package com.zgulde.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierRepository extends JpaRepository<Carrier, Long> {
    Carrier findByName(String name);
}
