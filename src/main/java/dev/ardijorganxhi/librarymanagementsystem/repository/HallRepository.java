package dev.ardijorganxhi.librarymanagementsystem.repository;

import dev.ardijorganxhi.librarymanagementsystem.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
}
