package com.example.blogging.repository;

import com.example.blogging.model.PublishedDeleted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishedDeletedRepository extends JpaRepository<PublishedDeleted, Long> {
}
