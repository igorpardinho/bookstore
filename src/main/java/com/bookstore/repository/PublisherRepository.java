package com.bookstore.repository;

import com.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    Publisher findByName(String name);
}
