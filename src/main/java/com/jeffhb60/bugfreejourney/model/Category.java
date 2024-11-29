package com.jeffhb60.bugfreejourney.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity @Table(name = "categories", uniqueConstraints = {@UniqueConstraint(columnNames = "category_name")})
@AllArgsConstructor @NoArgsConstructor
public class Category {
    @Column(name = "category_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long categoryId;

    @Column(name = "category_name", unique = true, nullable = false)
    @Size(min = 1, max = 50, message = "Error: Category must contain at least 1 character and no more than 50!")
    @NotBlank(message = "Error: Category name is a required filed and cannot be left blank!")
    @Getter @Setter
    private String categoryName;

    public Category(String name) {
        this.categoryName = name;
    }
}
