package com.example.springproject.repositories;

import com.example.springproject.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier,Long> {
}
