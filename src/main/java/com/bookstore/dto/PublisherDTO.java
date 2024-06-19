package com.bookstore.dto;

import com.bookstore.model.Book;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record PublisherDTO(@NotBlank String name,  Set<Book> books) {
}
