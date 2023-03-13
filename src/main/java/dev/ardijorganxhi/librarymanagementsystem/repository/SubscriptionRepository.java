package dev.ardijorganxhi.librarymanagementsystem.repository;

import dev.ardijorganxhi.librarymanagementsystem.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
