package com.bookstore.dto;

import com.bookstore.model.Author;
import com.bookstore.model.Publisher;
import com.bookstore.model.Review;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record BookDTO(@NotBlank String title , @NotNull Publisher publisher,@NotNull Set<Author> authors, Review review) {
}
