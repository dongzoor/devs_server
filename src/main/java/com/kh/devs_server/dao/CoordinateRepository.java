package com.kh.devs_server.dao;

import com.kh.devs_server.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
