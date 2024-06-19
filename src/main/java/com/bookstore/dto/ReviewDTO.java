package com.bookstore.dto;

import com.bookstore.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReviewDTO(@NotBlank String comment, @NotNull Book book) {
}
