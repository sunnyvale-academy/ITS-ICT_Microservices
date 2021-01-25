package org.example.book.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
public class Book {

    @Id
    private String bookId;
    @NotBlank(message = "Title is mandatory")
    private String title;

}
