package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Category extends BaseEntity {

    private String categoryName;
    private String description;
    private String categoryCode;

    public Category() {
    }

    public Category(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public Category(String categoryName, String description, String categoryCode) {
        this.categoryName = categoryName;
        this.description = description;
        this.categoryCode = categoryCode;
    }

    public Category(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String categoryName, String description, String categoryCode) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.categoryName = categoryName;
        this.description = description;
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                '}';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName) && Objects.equals(description, category.description) && Objects.equals(categoryCode, category.categoryCode);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(categoryName);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Objects.hashCode(categoryCode);
        return result;
    }
}
