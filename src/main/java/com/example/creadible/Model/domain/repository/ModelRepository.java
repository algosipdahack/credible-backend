package com.example.creadible.Model.domain.repository;

import com.example.creadible.Model.domain.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
