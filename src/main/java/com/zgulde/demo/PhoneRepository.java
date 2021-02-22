package com.zgulde.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    List<Phone> findByManufacturer(Company manufacturer);
}
